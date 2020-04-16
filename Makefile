##
# Simple Virtual Ecosystem
#
# Type 'make run' to compile and run.
# Type 'make run <test-option>' to make specific compile and run. See below variable, "TEST".
# Type 'make compile' to compile.
# Type 'make compile <test-option>' to make specific compile. See below variable, "TEST".
# Type 'make clean' to clean outputs.
#
# @Makefile
# @version 0.1

# Detects Operating System
ifeq ($(OS),Windows_NT)
	JPATHSEP := ;
else
	JPATHSEP := :
endif

#COMPILER
JC := javac

#SOURCE DIRECTORY
SRCDIR := src/

#TEST DIRECTORY
TESTDIR := test/

#BUILD DIRECTORY
BUILDDIR := build/

#TEST EXEC
TESTEXEC := Tester

# Build Options
# default and -1 makes source codes
# 0 makes tests for all modules
# 1 makes tests for core module
# 2 makes tests for stats module
# 3 makes tests for gui module
TEST ?= -1

#RED COLOR
RED := '\033[1;31m'

#GRAY COLOR
GRAY := '\033[0;37m'

#BLUE COLOR
BLUE := '\033[1;34m'

#PURPLE COLOR
PURPLE := '\033[1;35m'

#CYAN COLOR
CYAN := '\033[1;36m'

#NO COLOR
NOCOLOR := '\033[0m'

.PHONY: compile run clean
run: compile
	@echo -e $(GRAY) Running... $(NOCOLOR)
ifneq ($(TEST), -1)
	java -classpath $(BUILDDIR) $(TESTEXEC) $(TEST)
else
	@echo -e $(RED) make run for source is not implemented yet. $(NOCOLOR)
endif
	@echo $(PURPLE) Successful! $(NOCOLOR)

compile: | $(BUILDDIR)
	@echo -e $(GRAY) Compiling... $(NOCOLOR)
ifneq ($(TEST), -1)
	javac -d $(BUILDDIR) -classpath $(TESTDIR)$(JPATHSEP)$(SRCDIR) $(TESTDIR)$(TESTEXEC).java
else
	@echo -e $(RED) make compile for source is not implemented yet. $(NOCOLOR)
endif
	@echo $(BLUE) Successful! $(NOCOLOR)

$(BUILDDIR):
	mkdir $@

clean:
	rm -rf $(BUILDDIR)
	@echo -e $(CYAN) Cleaned output files... $(NOCOLOR)

# end
