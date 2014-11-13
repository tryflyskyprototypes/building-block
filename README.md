building-block
==============

You can run sample from "SamleExecutor.java".

If you want to change reading file, 
1. put your file in "com.tryflysky.buildingblock" package.
2. rewrite filename in "readFile()" method in SampleExecutor.java

You can generate reading file　by "FileGenerator.java"
rewrite these 2 parameters.
1. GENERATE_NUM        -> number of blocks
2. COLOR_VALIATION_NUM -> color valiations of block's each face.

notice:
Actually, the "FileGenerator.java" does not generate file.
It's only output file contents to your standard out (e.g. eclipse console).
You have to prepare empty file and then, do copy and paste FileGenerator's output to file.


