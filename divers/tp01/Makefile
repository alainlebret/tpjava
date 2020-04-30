JAVAC=javac
JFLAGS=-g
JAVADOC=javadoc
RM=rm

all: Sum.class Telegram.class Truncation.class

Sum.class: Sum.java
	$(JAVAC) $(JFLAGS) $^

Telegram.class: Telegram.java
	$(JAVAC) $(JFLAGS) $^

Truncation.class: Truncation.java
	$(JAVAC) $(JFLAGS) $^

doc:
	$(JAVADOC) *.java
	
clean:
	$(RM) *.class