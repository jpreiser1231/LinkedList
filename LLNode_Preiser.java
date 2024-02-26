public class LLNode_Preiser<T> implements Node<T>
  {
    private T data;
    private LLNode_Preiser<T> next;

    public LLNode_Preiser(T data)
    {
      this.data = data;
      data = null;
    }
    
    public LLNode_Preiser<T> getNext()
    {
      return next;
    }

    public void setNext(Node<T> newNext)
    {
      next = (LLNode_Preiser<T>)newNext;
    }

    public T getData()
    {
      return data;
    }

    public void setData(T newData)
    {
      data = newData;
    }
    
  }