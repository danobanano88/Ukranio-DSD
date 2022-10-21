JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  main.java \
		  Rectangulo.java \
		  Figura.java \
		  Cuadrado.java \
		  Perimetro.java \


default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
run:
	java main

