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

#EXECUTOR
JVM := java

# Build Options
# default and -1 makes source codes
# 0 makes tests for all modules
# 1 makes tests for core module
# 2 makes tests for stats module
# 3 makes tests for gui module
TEST ?= -1

#COLOR CODES
RED := '\033[1;31m'
GRAY := '\033[0;37m'
BLUE := '\033[1;34m'
PURPLE := '\033[1;35m'
CYAN := '\033[1;36m'
ENDCOLOR := '\033[0m'

#SOURCE DIRECTORY
SRCDIR := src/

#FILE SEARCHER FUNCTION
rwildcard = $(foreach d, $(wildcard $(1:=/*)), $(call rwildcard,$d,$2)) $(filter $(subst *,%,$2), $d)

#SOURCE FILES
SRCS := $(call rwildcard, src, *.java)

#BUILD DIRECTORY
BUILDDIR := build/

ifneq ($(TEST), -1)

#EXEC
EXEC := Tester

else

#EXEC
EXEC := ScenarioCheela

endif

#FX LIBRARIES
JAVAFX := --module-path $(PATH_TO_FX) --add-modules javafx.controls,javafx.swing

CLASSES := $(SRCS:$(SRCDIR)%.java=$(BUILDDIR)%.class)

COMPILEINFO := 1

$(EXEC): $(CLASSES)
	@echo -e $(PURPLE) Running... $(ENDCOLOR)
	$(JVM) -classpath $(BUILDDIR)$(JPATHSEP)$(PATH_TO_JFREE) $(JAVAFX) $@ $(TEST)
	@echo $(RED) Successful! $(ENDCOLOR)

$(BUILDDIR)%.class: $(SRCDIR)%.java | $(BUILDDIR)
	@if [ $(COMPILEINFO) -eq 1 ]; then \
		echo $(BLUE) Compiling: $(ENDCOLOR); \
		$(eval COMPILEINFO = 0) \
	fi;
	$(JC) -d $(BUILDDIR) -classpath $(SRCDIR)$(JPATHSEP)$(PATH_TO_JFREE) $(JAVAFX) $<

$(BUILDDIR):
	@echo -e $(GRAY) Creating folder $@ $(ENDCOLOR)
	mkdir $@

.PHONY: clean
clean:
	rm -rf $(BUILDDIR)
	@echo -e $(CYAN) Cleaned output files... $(ENDCOLOR)

# end
