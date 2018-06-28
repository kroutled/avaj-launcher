find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java com.avajLauncher.simulator.Simulator scenario.txt
