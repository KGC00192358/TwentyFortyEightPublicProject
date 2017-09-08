JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = \
	Hello.java

default: classes run

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
run: classes
	java Hello
