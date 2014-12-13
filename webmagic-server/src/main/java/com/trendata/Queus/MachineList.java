package com.trendata.Queus;

import com.trendata.Queus.Entity.Machine;

import java.util.List;

/**
 * Created by friddle on 12/10/14.
 */
public class MachineList {
	public static List<Machine> machines;
	public static synchronized  boolean addMachines(Machine machine)
	{
		return true;
	}
}
