all: 
	 
	@echo "Compiling..."
	@find   . -name "*.java" > sources.txt
	@javac -d .   @sources.txt
	@echo "Done."
	@java main.java  file
run: 
	@java main.java  file
