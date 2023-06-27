from abc import ABC, abstractmethod
import logging
import traceback


class ComplexNumber:
    """Класс, представляющий комплексное число"""

    def __init__(self, real_part, imaginary_part):
        self.real_part = real_part
        self.imaginary_part = imaginary_part


class I_CalculatorOperation(ABC):
    """Интерфейс выполнения операций калькулятора"""
    @abstractmethod
    def perform_operation(self, num_1: ComplexNumber, num_2: ComplexNumber) -> ComplexNumber:
        pass


class AdditionOperation(I_CalculatorOperation):
    """Механика операции сложения"""

    def perform_operation(self, num_1: ComplexNumber, num_2: ComplexNumber) -> ComplexNumber:
        real_part = num_1.real_part + num_2.real_part
        imaginary_part = num_1.imaginary_part + num_2.imaginary_part
        return ComplexNumber(real_part, imaginary_part)


class SubtractionOperation(I_CalculatorOperation):
    """Механика операции вычитания"""

    def perform_operation(self, num_1: ComplexNumber, num_2: ComplexNumber) -> ComplexNumber:
        real_part = num_1.real_part - num_2.real_part
        imaginary_part = num_1.imaginary_part - num_2.imaginary_part
        return ComplexNumber(real_part, imaginary_part)


class MultiplicationOperation(I_CalculatorOperation):
    """Механика операции умножения"""

    def perform_operation(self, num_1: ComplexNumber, num_2: ComplexNumber) -> ComplexNumber:
        real_part = (num_1.real_part * num_2.real_part) - \
            (num_1.imaginary_part * num_2.imaginary_part)
        imaginary_part = (num_2.real_part * num_1.imaginary_part) + \
            (num_1.real_part * num_2.imaginary_part)
        return ComplexNumber(real_part, imaginary_part)


class DivisionOperation(I_CalculatorOperation):
    """Механика операции вычитания"""

    def perform_operation(self, num_1: ComplexNumber, num_2: ComplexNumber) -> ComplexNumber:
        # знаменатель вещественной и мнимой частей
        denominator = num_2.real_part**2 + num_2.imaginary_part**2
        # Числитель вещественной части:
        numenator_1 = (num_1.real_part * num_2.real_part) + \
            (num_1.imaginary_part * num_2.imaginary_part)
        # Числитель мнимой части:
        numenator_2 = (num_2.real_part * num_1.imaginary_part) - \
            (num_1.real_part * num_2.imaginary_part)
        real_part = numenator_1 / denominator
        imaginary_part = numenator_2 / denominator
        return ComplexNumber(real_part, imaginary_part)


class Calculator:
    """Метод выполнения операций калькулятора и логирования в файл"""
    def __init__(self, userInterface):
        self.userInterface = userInterface

    logging.basicConfig(filename='calculator.log', level=logging.INFO,
                    format='%(asctime)s - %(message)s')

    @classmethod
    def log_operation(cls, operation):
        logging.info(operation)

    def run(self):
        try:
            num1_real_part = self.userInterface.get_number_real_part()
            num1_imaginary_part = self.userInterface.get_number_imaginary_part()
            num1 = ComplexNumber(num1_real_part, num1_imaginary_part)
            operation = self.userInterface.get_operation()
            num2_real_part = self.userInterface.get_number_real_part()
            num2_imaginary_part = self.userInterface.get_number_imaginary_part()
            num2 = ComplexNumber(num2_real_part, num2_imaginary_part)
            result = operation.perform_operation(num1, num2)
            self.userInterface.display_result(result)
            self.log_operation(
                f"Operation: {operation.__class__.__name__},\
                    Numbers: ({num1.real_part}+{num1.imaginary_part}i),\
                    ({num2.real_part}+{num2.imaginary_part}i),\
                    Result: ({result.real_part}+{result.imaginary_part}i)")

        except Exception as e:
            self.userInterface.display_error(traceback.format_exc())
