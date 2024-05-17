package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    @Test
    public void testTrueAdd() {
        Assert.assertEquals(Double.valueOf(3), MathQuestionService.q1Addition("1", "2"));
    }

    @Test
    public void testAddNumber1Empty() {
        try {
            MathQuestionService.q1Addition("", "2");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }
    }

    @Test
    public void testAddNumber2Empty() {
        try {
            MathQuestionService.q1Addition("1", "");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }
    }

    @Test
    public void testTrueSubtraction() {
        Assert.assertEquals(Double.valueOf(1), MathQuestionService.q2Subtraction("2", "1"));
    }

    @Test
    public void testSubtractionNumber1Empty() {
        try {
            MathQuestionService.q2Subtraction("", "1");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }
    }

    @Test
    public void testSubtractionNumber2Empty() {
        try {
            MathQuestionService.q2Subtraction("2", "");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }
    }

    @Test
    public void testTrueMultiplication() {
        Assert.assertEquals(Double.valueOf(12), MathQuestionService.q3Multiplication("3", "4"));
    }

    @Test
    public void testMultiplicationNumber1Empty() {
        try {
            MathQuestionService.q3Multiplication("", "4");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }
    }

    @Test
    public void testMultiplicationNumber2Empty() {
        try {
            MathQuestionService.q3Multiplication("3", "");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }
    }

    @Test
    public void testQ1AdditionEmptyInputs() {
        try {
            MathQuestionService.q1Addition("", "2.0");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }

        try {
            MathQuestionService.q1Addition("1.0", "");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }

        try {
            MathQuestionService.q1Addition("", "");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }
    }

    @Test
    public void testQ1AdditionNullInputs() {
        try {
            MathQuestionService.q1Addition(null, "2.0");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }

        try {
            MathQuestionService.q1Addition("1.0", null);
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }

        try {
            MathQuestionService.q1Addition(null, null);
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }
    }

    @Test
    public void testQ2SubtractionEmptyInputs() {
        try {
            MathQuestionService.q2Subtraction("", "2.0");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }

        try {
            MathQuestionService.q2Subtraction("3.0", "");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }

        try {
            MathQuestionService.q2Subtraction("", "");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }
    }

    @Test
    public void testQ2SubtractionNullInputs() {
        try {
            MathQuestionService.q2Subtraction(null, "2.0");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }

        try {
            MathQuestionService.q2Subtraction("3.0", null);
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }

        try {
            MathQuestionService.q2Subtraction(null, null);
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }
    }

    @Test
    public void testQ3MultiplicationEmptyInputs() {
        try {
            MathQuestionService.q3Multiplication("", "2.0");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }

        try {
            MathQuestionService.q3Multiplication("3.0", "");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }

        try {
            MathQuestionService.q3Multiplication("", "");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }
    }

    @Test
    public void testQ3MultiplicationNullInputs() {
        try {
            MathQuestionService.q3Multiplication(null, "2.0");
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }

        try {
            MathQuestionService.q3Multiplication("3.0", null);
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }

        try {
            MathQuestionService.q3Multiplication(null, null);
            Assert.fail("Expected ValidationException");
        } catch (ValidationException e) {
            Assert.assertEquals("Input numbers must not be null or empty", e.getMessage());
        }
    }
}
