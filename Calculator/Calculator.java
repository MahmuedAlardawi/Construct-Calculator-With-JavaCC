/* Calculator.java */
/* Generated By:JavaCC: Do not edit this line. Calculator.java */
package CPCS302_project3;
import java.io.*;
import java.util.*;

public class Calculator implements CalculatorConstants {
    public static void main(String[] args) throws IOException  {
        Calculator parser = new Calculator(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (true) {
            System.out.print("Enter expression or type 'exit' to quit: ");
            try {
                input = br.readLine();
                if ("exit".equalsIgnoreCase(input.trim())) {
                    System.out.println("Program terminated.");
                    break;
                }
                parser.ReInit(new ByteArrayInputStream(input.getBytes()));
                double result = parser.Expression();
                System.out.println("Result: " + result);
            }
            catch (ParseException e) {
                System.out.println("Invalid expression. Please try again.");
            }
            catch (Error e) {
                System.out.println("Invalid expression. Please try again.");
            }
            System.out.println("");
        }
    }

  final public void Start(PrintStream printStream) throws ParseException, NumberFormatException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case MINUS:
      case OPEN_PAR:
      case NUMBER:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      value = Expression();
      jj_consume_token(EOL);
printStream.println( value ) ;
    }
    jj_consume_token(0);
}

  final public double Expression() throws ParseException, NumberFormatException {double i ;
        double value ;
    value = Term();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:
      case MINUS:{
        ;
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:{
        jj_consume_token(PLUS);
        i = Term();
value += i ;
        break;
        }
      case MINUS:{
        jj_consume_token(MINUS);
        i = Term();
value -= i ;
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
{if ("" != null) return value ;}
    throw new Error("Missing return statement in function");
}

  final public double Term() throws ParseException, NumberFormatException {double i ;
        double value ;
    value = Primary();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TIMES:
      case DIVIDE:{
        ;
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TIMES:{
        jj_consume_token(TIMES);
        i = Primary();
value *= i ;
        break;
        }
      case DIVIDE:{
        jj_consume_token(DIVIDE);
        i = Primary();
value /= i ;
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
{if ("" != null) return value ;}
    throw new Error("Missing return statement in function");
}

  final public double Primary() throws ParseException, NumberFormatException {Token t ;
        double d ;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case NUMBER:{
      t = jj_consume_token(NUMBER);
{if ("" != null) return Double.parseDouble( t.image ) ;}
      break;
      }
    case OPEN_PAR:{
      jj_consume_token(OPEN_PAR);
      d = Expression();
      jj_consume_token(CLOSE_PAR);
{if ("" != null) return d ;}
      break;
      }
    case MINUS:{
      jj_consume_token(MINUS);
      d = Primary();
{if ("" != null) return -d ;}
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  /** Generated Token Manager. */
  public CalculatorTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[6];
  static private int[] jj_la1_0;
  static {
	   jj_la1_init_0();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x290,0x18,0x18,0x60,0x60,0x290,};
	}

  /** Constructor with InputStream. */
  public Calculator(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Calculator(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new CalculatorTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Calculator(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new CalculatorTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new CalculatorTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Calculator(CalculatorTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(CalculatorTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[11];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 6; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 11; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
