from CalcComplexModel import *
from UserInterface import *

if __name__ == '__main__':
    userInterface = ConsoleUserInterface()
    calculator = Calculator(userInterface)
    calculator.run()