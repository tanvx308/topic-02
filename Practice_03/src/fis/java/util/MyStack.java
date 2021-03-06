package fis.java.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStack<E extends Comparable<E>> {
	
	private Object[] elementStack;

	private int maxSize;

	private int topIndex;

	// khởi tạo không tham số
	public MyStack() {
		this.maxSize = 0;
		this.topIndex = -1;
		this.elementStack = new Object[this.maxSize];
	}

	// khởi tạo có tham số
	public MyStack(int maxSize) {
		this.maxSize = maxSize;
		this.topIndex = -1;
		this.elementStack = new Object[maxSize];
	}

	// hàm thêm đối tượng vào cuối danh sách
	public E push(E item) {
		if (this.maxSize == 0) {
			this.maxSize = 1;
			this.topIndex = 0;
			this.elementStack = new Object[this.maxSize];
			this.elementStack[topIndex] = item;
		} else {
			this.maxSize++;
			this.topIndex++;
			Object[] cloneStack = new Object[this.maxSize];
			for (int i = 0; i < elementStack.length; i++) {
				cloneStack[i] = this.elementStack[i];
			}
			cloneStack[this.topIndex] = item;
			this.elementStack = cloneStack;
		}
		return item;
	}

	// hàm lấy về phần tử cuối cùng và xoá
	public E pop() {
		if (this.isEmpty()) {
			return null;
		} else {
			E result = (E) this.elementStack[this.topIndex];
			if (this.maxSize == 1) {
				this.maxSize = 0;
				this.topIndex = -1;
				this.elementStack = new Object[this.maxSize];
			} else {
				this.maxSize--;
				this.topIndex--;
				Object[] cloneStack = new Object[this.maxSize];
				for (int i = 0; i < cloneStack.length; i++) {
					cloneStack[i] = this.elementStack[i];
				}
				this.elementStack = cloneStack;
			}
			return result;
		}

	}
	
	//hàm lấy về phần tử cuối cùng
	public E top() {
		if(this.maxSize > 0) {
			return (E)this.elementStack[topIndex];
		}
		return null;
	}
	
	//hàm clear stack
	public void clear() {
		this.maxSize = 0;
		this.topIndex = -1;
		this.elementStack = new Object[maxSize];
	}

	// hàm kiểm tra stack có rỗng k
	public boolean isEmpty() {
		return this.maxSize == 0;
	}

	// hàm lấy về size của stack
	public int size() {
		return this.maxSize;
	}
	
	//hàm forEach
	public void forEach(Consumer<E> consumer) {
		for(int i = 0; i < maxSize; i++) {
			consumer.accept((E)elementStack[i]);
		}
	}
	
	//hàm sắp xếp stack theo comparable
	public void sort() {
		for(int i = 0; i < this.maxSize - 1; i++) {
			for(int j = 0; j < this.maxSize - i - 1; j++) {
				E e1 = (E)this.elementStack[j];
				E e2 = (E)this.elementStack[j + 1];
				if(e1.compareTo(e2) > 0) {
					E temp = (E)this.elementStack[j];
					this.elementStack[j] = this.elementStack[j + 1];
					this.elementStack[j + 1] = temp;
				}
			}
		}
	}
	
	//hàm sắp xếp stack theo comparator
		public void sort(Comparator<E> comparator) {
			for(int i = 0; i < this.maxSize - 1; i++) {
				for(int j = 0; j < this.maxSize - i - 1; j++) {
					E e1 = (E)this.elementStack[j];
					E e2 = (E)this.elementStack[j + 1];
					if(comparator.compare(e1, e2) > 0) {
						E temp = (E)this.elementStack[j];
						this.elementStack[j] = this.elementStack[j + 1];
						this.elementStack[j + 1] = temp;
					}
				}
			}
		}
		
	// hàm in ra stack
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("MyStack [");
		for (int i = 0; i < maxSize; i++) {
			if (i == maxSize - 1) {
				sb.append(elementStack[i]);
			} else {
				sb.append(elementStack[i] + ", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
