
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Thu Sep 17 23:12:22 CST 2015
//----------------------------------------------------

package net.project.parser.sequences;


/** CUP v0.11a beta 20060608 generated parser.
  * @version Thu Sep 17 23:12:22 CST 2015
  */
public class SequencesParser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public SequencesParser() {super();}

  /** Constructor which sets the default scanner. */
  public SequencesParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public SequencesParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\011\000\002\002\004\000\002\002\005\000\002\003" +
    "\003\000\002\003\004\000\002\004\005\000\002\005\004" +
    "\000\002\005\005\000\002\006\005\000\002\006\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\024\000\004\004\005\001\002\000\004\002\026\001" +
    "\002\000\004\006\006\001\002\000\006\011\016\014\013" +
    "\001\002\000\006\005\uffff\006\006\001\002\000\004\005" +
    "\011\001\002\000\004\002\000\001\002\000\004\005\ufffe" +
    "\001\002\000\004\012\024\001\002\000\004\010\022\001" +
    "\002\000\004\007\021\001\002\000\004\012\017\001\002" +
    "\000\004\013\020\001\002\000\004\010\ufffa\001\002\000" +
    "\006\005\ufffd\006\ufffd\001\002\000\010\007\ufffc\011\016" +
    "\014\013\001\002\000\004\007\ufffb\001\002\000\004\015" +
    "\025\001\002\000\004\010\ufff9\001\002\000\004\002\001" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\024\000\004\002\003\001\001\000\002\001\001\000" +
    "\006\003\007\004\006\001\001\000\006\005\014\006\013" +
    "\001\001\000\006\003\011\004\006\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\005\022\006\013\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$SequencesParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$SequencesParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$SequencesParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$SequencesParser$actions {
  private final SequencesParser parser;

  /** Constructor */
  CUP$SequencesParser$actions(SequencesParser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$SequencesParser$do_action(
    int                        CUP$SequencesParser$act_num,
    java_cup.runtime.lr_parser CUP$SequencesParser$parser,
    java.util.Stack            CUP$SequencesParser$stack,
    int                        CUP$SequencesParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$SequencesParser$result;

      /* select the action based on the action number */
      switch (CUP$SequencesParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // scenario_attr ::= ORDER EQUAL INT 
            {
              Object RESULT =null;

              CUP$SequencesParser$result = parser.getSymbolFactory().newSymbol("scenario_attr",4, ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.elementAt(CUP$SequencesParser$top-2)), ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.peek()), RESULT);
            }
          return CUP$SequencesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // scenario_attr ::= NAME EQUAL ID 
            {
              Object RESULT =null;

              CUP$SequencesParser$result = parser.getSymbolFactory().newSymbol("scenario_attr",4, ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.elementAt(CUP$SequencesParser$top-2)), ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.peek()), RESULT);
            }
          return CUP$SequencesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // scenario_attrs ::= scenario_attr SEMICOLON scenario_attrs 
            {
              Object RESULT =null;

              CUP$SequencesParser$result = parser.getSymbolFactory().newSymbol("scenario_attrs",3, ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.elementAt(CUP$SequencesParser$top-2)), ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.peek()), RESULT);
            }
          return CUP$SequencesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // scenario_attrs ::= scenario_attr SEMICOLON 
            {
              Object RESULT =null;

              CUP$SequencesParser$result = parser.getSymbolFactory().newSymbol("scenario_attrs",3, ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.elementAt(CUP$SequencesParser$top-1)), ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.peek()), RESULT);
            }
          return CUP$SequencesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // sequences_element ::= INIT_SCENARIO scenario_attrs MORE_THAN_S 
            {
              Object RESULT =null;

              CUP$SequencesParser$result = parser.getSymbolFactory().newSymbol("sequences_element",2, ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.elementAt(CUP$SequencesParser$top-2)), ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.peek()), RESULT);
            }
          return CUP$SequencesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // sequences_elements ::= sequences_element sequences_elements 
            {
              Object RESULT =null;

              CUP$SequencesParser$result = parser.getSymbolFactory().newSymbol("sequences_elements",1, ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.elementAt(CUP$SequencesParser$top-1)), ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.peek()), RESULT);
            }
          return CUP$SequencesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // sequences_elements ::= sequences_element 
            {
              Object RESULT =null;

              CUP$SequencesParser$result = parser.getSymbolFactory().newSymbol("sequences_elements",1, ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.peek()), RESULT);
            }
          return CUP$SequencesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // sequences ::= INIT_SCENARIOS sequences_elements END_SCENARIOS 
            {
              Object RESULT =null;

              CUP$SequencesParser$result = parser.getSymbolFactory().newSymbol("sequences",0, ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.elementAt(CUP$SequencesParser$top-2)), ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.peek()), RESULT);
            }
          return CUP$SequencesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= sequences EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.elementAt(CUP$SequencesParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.elementAt(CUP$SequencesParser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$SequencesParser$stack.elementAt(CUP$SequencesParser$top-1)).value;
		RESULT = start_val;
              CUP$SequencesParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.elementAt(CUP$SequencesParser$top-1)), ((java_cup.runtime.Symbol)CUP$SequencesParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$SequencesParser$parser.done_parsing();
          return CUP$SequencesParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

