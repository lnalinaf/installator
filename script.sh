#!/bin/bash
rm -rf build/* ;  
javac -target 1.7 -source 1.7 -sourcepath src -cp ~/repos/installer/ship.jar -d build `find src -name "*.java"`;
cd build/;
cp ~/repos/installer/ship.jar ./ ;
jar -tf ~/repos/installer/ship.jar ./ ;
 jar -cf ../testShip.jar *; 
cd ../
