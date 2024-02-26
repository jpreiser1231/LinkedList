public class LL_Preiser<T> implements LinkedListInterface<T>
{
  private LLNode_Preiser<T> first;

  public LL_Preiser()
  {
    first = null; 
  }

  public boolean contains(Object o) //GOOD
  {
    LLNode_Preiser<T> current = first;
    while(current != null)
      {
        if(current.getData().equals(o))
        {
          return true;
        }
        current = current.getNext();
      }
    return false;
  }

  public int indexOf(Object o)//GOOD
  {
    int index = 0;
    LLNode_Preiser<T> current = first;
    while(current != null)
      {
        if(current.getData().equals(o))
          {
          return index;
          }
        index++;
        current = current.getNext();
      }
      return -1;
  }

  public int lastIndexOf(Object o)//GOOD
  {
    int index = 0; 
    int lastIndex = -1;
    LLNode_Preiser<T> current = first;
    while (current != null)
      {
        if(current.getData().equals(o))
        {
          lastIndex = index;
        }
        current = current.getNext();
        index++;
      }
  return lastIndex;
  }

  public boolean isEmpty()//GOOD
  {
  if(first==null)
  {
    return true;
  }
    else
  {
    return false;
  }
  }

  public int size()//GOOD
  {
    LLNode_Preiser<T> current = first;
    int size = 0;

    while(current != null)
      {
        size++;
        current = current.getNext();
      }
    return size;
  }

  public T get(int index)//GOOD
  {
    int i = 0;
    LLNode_Preiser<T> current = first;
    if(index >= this.size() || index < 0)
      throw new IndexOutOfBoundsException();
      while(i < index)
        {
          i++;
          current = current.getNext();
        }
    return current.getData();
  }

  public T set(int index, T element)//GOOD
  {
    T elementChanged = null;
    LLNode_Preiser<T> current = first;
    if (index >= this.size() || index < 0)
      throw new IndexOutOfBoundsException();
    int i = 0;
    current = first;
    while (current != null)
      {
        if(i == index)
        {
          elementChanged = current.getData();
          current.setData(element);
          return elementChanged;
        }
        i++;
        current = current.getNext();
        
      }
    return elementChanged;
  }

  public void clear()//GOOD
  {
    first = null;
  }

  public void add(T element)//GOOD
  {
  LLNode_Preiser<T> newNode = new LLNode_Preiser<T>(element);
  LLNode_Preiser<T> prevNode = null;
  LLNode_Preiser<T> nextNode = first;
  if (first == null)
  {
    first = newNode;
  }
    else
  {
  while(nextNode != null)
    {
      prevNode = nextNode;
      nextNode = nextNode.getNext();
    }
    prevNode.setNext(newNode);
  }
    }

  public void add(int index, T element)//GOOD
  {
    int i = 0; 
    LLNode_Preiser<T> newNode = new LLNode_Preiser<T>(element);
    LLNode_Preiser<T> prevNode = null;
    LLNode_Preiser<T> nextNode = first;
    if (index > this.size() || index < 0)
      throw new IndexOutOfBoundsException();
    
    if(this.isEmpty())
    {
      first = newNode;
    } 
    else
    {
    if(index == 0)
    {
      newNode.setNext(first);
      first = newNode;
    }
    while (i < index)
      {
        prevNode = nextNode;
        nextNode = nextNode.getNext();
        i++;
      
        if (i == index)
        {
          newNode.setNext(nextNode);
          prevNode.setNext(newNode);
        }
      }
        if(index == this.size())
        {
          prevNode.setNext(newNode);
        }
    }
  }

  public boolean remove(T element)//GOOD
  {
    LLNode_Preiser<T> nextNode = first;
    LLNode_Preiser<T> prevNode = null;

    if(first.getData().equals(element))
    {
      first = first.getNext();
      return true;
    }
    else
    {
      while(nextNode != null)
        {
          if(nextNode.getData().equals(element))
          {
            prevNode.setNext(nextNode.getNext());
            return true;
          }
          prevNode = nextNode;
          nextNode = nextNode.getNext();
        }
    }
    return false;
  }

  public T remove(int index)//GOOD
  {
    LLNode_Preiser<T> nextNode = first;
    LLNode_Preiser<T> prevNode = null;
    int i = 0;
    if(index >= this.size() || index < 0)
      throw new IndexOutOfBoundsException();
    if(index == 0)
    {
      first = nextNode.getNext();
    }
    else
    {
     while(i < index)
       {
         prevNode = nextNode;
         nextNode = nextNode.getNext();
         i++;
       }
      prevNode.setNext(nextNode.getNext());
    }
    return nextNode.getData();
 }

  
}