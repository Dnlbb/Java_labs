#ifndef TIC_TAC_TOE_BOARD_H
#define TIC_TAC_TOE_BOARD_H

class TicTacToeBoard {
private:
    char** board;
    int size;

public:
    TicTacToeBoard(int n);
    TicTacToeBoard(const TicTacToeBoard& other);
    ~TicTacToeBoard();
    TicTacToeBoard& operator=(TicTacToeBoard& other);

    int getSize() const;
    char& getCell(int row, int col);
    char& getCellReference(int row, int col); 
    bool isFinalPosition() const;
};

#endif 
