package com.trendata.Queus;

import com.trendata.Config.Constant;
import com.trendata.Queus.Entity.Machine;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by friddle on 12/10/14.
 * machine host_name better be the ip
 * use the synchronize + HashMap or
 */
public class MachineList {
	public static volatile ConcurrentHashMap<String,Machine> machines;
	public static synchronized  boolean addMachines(Machine machine)
	{
		try
		{
			machines.put(machine.host_name,machine);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}


	public static synchronized void setBlockList(String blockhost,String  machinehost)
	{
		machines.get(machinehost).blocklists.put(blockhost,new Timestamp(new Date().getTime()));
	}

	public static synchronized  boolean removeMachines(Machine machine)
	{
		machines.remove(machine.host_name);
		return true;
	}

	public static boolean isBlock(Machine machine,String hostname)
	{
		if(!machines.containsKey(machine.host_name))
		{
			addMachines(machine);
			return false;
		}
		else
		{
			if(!machines.get(machine.host_name).blocklists.containsKey(hostname))
			{
				return false;
			}
			else
			{
				Map<String,Timestamp> blocklists=machines.get(machine.host_name).blocklists;
				Timestamp lasttime=blocklists.get(hostname);
				Timestamp now=new Timestamp(new java.util.Date().getTime());
				if((now.getTime()-lasttime.getTime())>Constant.timeout)
				{
					blocklists.remove(machine.host_name);
					return false;
				}
				else
				{
				   return true;
				}
			}
		}
	}
}
