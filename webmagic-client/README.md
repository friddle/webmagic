1.pipeline and process must be indivial,so the process must contains function to let the pipeline do things
2.all the base class or interface must be in one package.for check it right
3.write the process first,do not consider the entity.


info
----
1.the pipeline name,the process name ->
2.the databasesetting interface<--must be include in all the base database pipeline,and the other doesn't need it
3.the work just got the errormessage right and back.
4.class type->info to mybatis mapper

Usage:
-----------
Processor extends DistributorProcess
Pipeline  extends DistributorPipeline

when-->process(page)
{
    //page->getthings()
    processObject(object)
}
