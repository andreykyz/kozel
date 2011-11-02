CXX		= g++
CXXFLAGS	=
INCPATH       = #-I/usr/share/qt4/mkspecs/linux-g++ -I. -I/usr/include/qt4/QtCore -I/usr/include/qt4/QtCore -I/usr/include/qt4/QtGui -I/usr/include/qt4/QtGui -I/usr/include/qt4 -I. -I. -I.
LIBS          = #$(SUBLIBS)  -L/usr/lib/qt4 -lQtGui -L/usr/lib/qt4 -L/usr/lib -lpng -lSM -lICE -lXrender -lXrandr -lXfixes -lXcursor -lfreetype -lfontconfig -lXext -lX11 -lQtCore -lz -lm -lrt -ldl -lpthread
main:	main.o card.o board.o
	$(CXX) $(CXXFLAGS) -o card_nogui main.o card.o board.o $(LIBS)
	
main.o:	main.cpp card.h board.h
	$(CXX) -c $(CXXFLAGS) main.cpp 
	
card.o:	card.cpp card.h
	$(CXX) -c $(CXXFLAGS) card.cpp
	
board.o:	board.cpp board.h
	$(CXX) -c $(CXXFLAGS) $(INCPATH) board.cpp
	
massive.o:	massive.cpp massive.h
	$(CXX) -c $(CXXFLAGS) $(INCPATH) massive.cpp
clean:
	rm card_nogui *.o