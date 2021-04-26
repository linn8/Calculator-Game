import java.util.Random;
public class Equation {
    private int a;
    private int b;
    private int c;
    private char op1;
    private char op2;

    Equation(Random r){
	// genereating random operations
	op1 = getOperation(r.nextInt(4));
	do {
	    op2 = getOperation(r.nextInt(4));
	} while(op1 == op2);
	
	// generating 3 variables, according to operators
	a = r.nextInt(100);
	if (op1 == '*') {
	    b = r.nextInt(13); // can't multipy a number by > 12 bcoz i can't solve such equations
	} else if (op1 == '/') { // if we are gonna divide, we are making sure it generates only integer values
	    b = r.nextInt(12) + 1;
	    a = r.nextInt(13) * b;
	} else { // if op1 is addition or subtraction
	    b = r.nextInt(100);
	}

	if (op2 == '*') {
	    c = r.nextInt(13);
	} else if (op2 == '/') {
	    c = r.nextInt(12) + 1;
	    b = r.nextInt(13) * c;
	} else {
	    c = r.nextInt(100);
	}
	
	System.out.println(this);
    }
    
    private char getOperation(int i) {
	switch(i) {
	case 0:
	    return '+';
	case 1:
	    return '-';
	case 2:
	    return '*';
	case 3:
	    return '/';
	default:
	    return '!';
	}
    }

    
    private int operate(int a, int b, char op) {
	switch(op) {
	case '+':
	    return a+b;
	case '-':
	    return a-b;
	case '*':
	    return a*b;
	case '/':
	    return a/b;
        default:
            return 0;
	}
    }

    public int solution() {
	/*
	 * there are 2 cases, the second operator being +-, and it being *,/
	 * normally, we evaulute the first expression (a op1 b) and then the second expression (first case)
	 * unless the second operator being *, /, if so, we evalutes the second expression first(second case)
	 * there is also one special case, (a / b * c), in which we evalutes the first expression even though
	 * the second operator is *,/
	 * feel free to fix this if an error is found
	 */
	int ret = 0;
	if (op2 == '+' || op2 == '-' || (op1 == '/' && op2 == '*')) {
	// a (+-) b (+-) c or a (*/) b (+-) c or special case (a / b * c)
	    ret = operate(a, b, op1);
	    ret = operate(ret, c, op2);
	} else if (op2 == '*' || op2 == '/') {
	// a (+-) b (*/) c or a * b (*/) c
	    ret = operate(b, c, op2);
	    ret = operate(a, ret, op1);
	}
	return ret;
    }
    
    public String toString() {
	return String.format("%d %c %d %c %d = ?", a, op1, b, op2, c);
    }
}
