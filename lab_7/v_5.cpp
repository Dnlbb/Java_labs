#include "declaration.h"
#include <iostream>

TicTacToeBoard::TicTacToeBoard(int n) {
    size = n;
    board = new char*[size];
    for (int i = 0; i < size; ++i) {
        board[i] = new char[size];
        for (int j = 0; j < size; ++j) {
            board[i][j] = '-';
        }
    }
}

TicTacToeBoard::TicTacToeBoard(const TicTacToeBoard& other) {
    size = other.size;
    board = new char*[size];
    for (int i = 0; i < size; ++i) {
        board[i] = new char[size];
        for (int j = 0; j < size; ++j) {
            board[i][j] = other.board[i][j];
        }
    }
}

TicTacToeBoard::~TicTacToeBoard() {
    for (int i = 0; i < size; ++i) {
        delete[] board[i];
    }
    delete[] board;
}

TicTacToeBoard& TicTacToeBoard::operator=(TicTacToeBoard& other) {
    if (this != &other) {
        for (int i = 0; i < size; ++i) {
            delete[] board[i];
        }
        delete[] board;
        size = other.size;
        board = new char*[size];
        for (int i = 0; i < size; ++i) {
            board[i] = new char[size];
            for (int j = 0; j < size; ++j) {
                board[i][j] = other.board[i][j];
            }
        }
    }
    return *this;
}

int TicTacToeBoard::getSize() const {
    return size;
}


char& TicTacToeBoard::getCellReference(int row, int col) {
    return board[row][col]; 
}

bool TicTacToeBoard::isFinalPosition() const {
    for (int i = 0; i < size; ++i) {
        char rowSymbol = board[i][0];
        char colSymbol = board[0][i];
        bool rowWin = true;
        bool colWin = true;
        for (int j = 1; j < size; ++j) {
            if (board[i][j] != rowSymbol)
                rowWin = false;
            if (board[j][i] != colSymbol)
                colWin = false;
        }
        if (rowWin || colWin)
            return true;
    }

    
    char mainDiagSymbol = board[0][0];
    bool mainDiagWin = true;
    for (int i = 1; i < size; ++i) {
        if (board[i][i] != mainDiagSymbol)
            mainDiagWin = false;
    }
    if (mainDiagWin)
        return true;

    char antiDiagSymbol = board[0][size - 1];
    bool antiDiagWin = true;
    for (int i = 1; i < size; ++i) {
        if (board[i][size - 1 - i] != antiDiagSymbol)
            antiDiagWin = false;
    }
    if (antiDiagWin)
        return true;

    return false;
}
