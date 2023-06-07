JAVAFILES :=   $(find  ./**/**.java)
all: 
	 
	@echo "Compiling..."
	@find   . -name "*.java" > sources.txt
	@javac   @sources.txt
	@echo "Done."
	@java main.java  file
