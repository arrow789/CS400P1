all: compile test



compile: 

test: clean
	javac -cp .:junit5.jar TestHashTable1.java
	java -jar junit5.jar --class-path . --scan-classpath --details tree

clean:
	$(RM) *.class
