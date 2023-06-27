import sys
from CalcComplexModel import *
from abc import ABC, abstractmethod


class I_UserInterface(ABC):
    """Интерфейс, отвечающий за взаимодействие с пользователем и отображение информации на экране """
    @abstractmethod
    def display_result(self, result: str) -> None:
        pass

    @abstractmethod
    def display_error(self, message: str) -> None:
        pass

    @abstractmethod
    def get_number_real_part(self) -> float:
        pass

    @abstractmethod
    def get_number_imaginary_part(self) -> float:
        pass

    @abstractmethod
    def get_operation(self) -> 'I_CalculatorOperation':
        pass


class ConsoleUserInterface(I_UserInterface):
    def __init__(self):
        self.scanner = sys.stdin

    def display_result(self, result):
        print(f"Результат: {result.real_part}+{result.imaginary_part}i")

    def display_error(self, message):
        print("Ошибка: ", message)

    def get_number_real_part(self):
        print("Введите вещественную часть числа: ")
        return float(input())

    def get_number_imaginary_part(self):
        print("Введите мнимую часть числа: ")
        return float(input())

    def get_operation(self):
        print("Введите операцию (+ - * /): ")
        operation = input()
        if operation == "+":
            return AdditionOperation()
        elif operation == "-":
            return SubtractionOperation()
        elif operation == "*":
            return MultiplicationOperation()
        elif operation == "/":
            return DivisionOperation()
        else:
            raise ValueError("Неприемлемая операция: " + operation)
