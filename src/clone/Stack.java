package clone;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by mac on 2017/10/12.
 */
public class Stack implements Cloneable{
    private Object[] elements;
    private  int size=0;
    private static final  int DEFAULT_INITIAL_CAPACITY=16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    public void push(Object o){
        ensureCapacity();
        elements[size++]=o;
    }
    public Object pop(){
        if(size==0){
            throw new EmptyStackException();
        }
        Object result=elements[--size];
        elements[size]=null;
        return result;
    }
    public  void ensureCapacity(){
        if(elements.length==size){
            elements= Arrays.copyOf(elements,2*size+1);
        }
    }



    @Override public Stack clone() throws CloneNotSupportedException {
        Stack result = (Stack) super.clone();
        result.elements=elements.clone();
        return result;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Stack stack=new Stack();

        for(int i=1;i<18;i++){
            stack.push(i);
        }
        Stack stack1=stack.clone();
        stack.push(18);
    }
}
