import java.util.LinkedList;
import java.util.List;

interface Statement{
    void eval();
}

class IfStatement implements Statement{
    private Expression cause;
    private Statement trueStatement;
    private Statement falseStatement;

    public IfStatement(Expression cause, Statement ts){
        this.cause = cause;
        this.trueStatement = ts;
    }

    public IfStatement(Expression cause, Statement ts, Statement fs){
        this(cause, ts);
        this.falseStatement = fs;
    }

    @Override
    public void eval() {
        if(cause.eval() != 0)
            trueStatement.eval();
        else
            falseStatement.eval();
    }
}

class WhileStatement implements Statement{
    private Expression cause;
    private Statement stm;


    public WhileStatement(Expression cause, Statement stm) {
        this.cause = cause;
        this.stm = stm;
    }

    @Override
    public void eval() {
        for(int i = 0; i < 1000 && cause.eval() > 0; i++){
            stm.eval();
        }
    }
}


class BlockStatement implements Statement{
    private List<Statement> list;

    public BlockStatement(List<Statement> l){
        this.list = l;
    }

    @Override
    public void eval(){
        for(Statement s : list)
            s.eval();
    }
}


class Expression{

    int eval(){
        return 0;
    }
}



public class Parser {
    
}
