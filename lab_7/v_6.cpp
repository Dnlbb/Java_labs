#include "declaration.h"
#include <iostream>

void printBoard(TicTacToeBoard& board) {
    int size = board.getSize();
    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            std::cout << board.getCell(i, j) << " ";
        }
        std::cout << std::endl;
    }
}

int main() {
    TicTacToeBoard board(3);

    board.getCellReference(0, 0) = 'X';
    board.getCellReference(1, 1) = 'O';
    board.getCellReference(2, 2) = 'X';
    std::cout << "Board size: " << board.getSize() << "x" << board.getSize() << std::endl;
    printBoard(board);
    if (board.isFinalPosition()) {
        std::cout << "Final position" << std::endl;
    } else {
        std::cout << "Not a final position" << std::endl;
    }

    return 0;
}
