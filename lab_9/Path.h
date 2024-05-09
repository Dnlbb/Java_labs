#include <array>

template<typename T>
class Change {
private:
    std::array<T, 9> denominations = {};
public:
    Change() : denominations({}) {}
    T& operator()(int index) {
        return denominations[index];
    }

    Change operator+(Change& other) {
        Change result;
        for (int i = 0; i < 9; ++i) {
            result.denominations[i] = this->denominations[i] + other.denominations[i];
        }
        return result;
    }

    Change operator-(Change& other) {
        Change result;
        for (int i = 0; i < 9; ++i) {
           if (this->denominations[i] < other.denominations[i]) {
            result.denominations[i] = this->denominations[i];
        } else {
            result.denominations[i] = other.denominations[i];
          }
        }
        return result;
    }
};
