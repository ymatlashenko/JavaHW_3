package HW_3;

public class AList2 implements EList
{
    private int[] array = new int[100];
    private int front = 50;
    private int rear = 50;

    AList2()
    {

    }

    AList2(int[] ini)
    {
	init(ini);
    }

    // ==============================================
    // init
    // ==============================================

    @Override
    public void init(int[] ini) {
	array = new int[100];
	front = 50;
	rear = 50;

	if (ini == null || ini.length == front) {
	    return;
	}

	while (array.length < ini.length) {
	    resize();
	}

	front = (array.length - ini.length) / 2;
	rear = front + ini.length;

	for (int i = front, j = 0; i < rear; i++, j++) {
	    array[i] = ini[j];
	}
    }

    @Override
    public int size() {
	return rear - front;
    }
    // ==============================================
    // toArray
    // ==============================================

    @Override
    public int[] toArray() {
	int[] outputArray = new int[size()];

	for (int i = front, j = 0; i < rear; i++, j++) {
	    outputArray[j] = array[i];
	}

	return outputArray;
    }

    // ==============================================
    // addStart
    // ==============================================
    @Override
    public void addStart(int value) {
	sizeControl();

	if (front == 0 && rear != array.length) {
	    balance();
	} else {
	    array[--front] = value;
	}
    }

    // ==============================================
    // addEnd
    // ==============================================

    @Override
    public void addEnd(int value) {
	sizeControl();

	if (rear == array.length && front != 0) {
	    balance();
	} else {
	    array[rear++] = value;
	    ;
	}
    }

    // ==============================================
    // addPos
    // ==============================================

    @Override
    public void addPos(int pos, int value) {
	sizeControl();

	if (pos < 0 || pos > size()) {
	    throw new ListIsEmptyException();
	}

	if (front == 0 && rear != array.length) {
	    balance();
	} else if (rear == array.length && front != 0) {
	    balance();
	} else {
	    int temp = array[pos + front];
	    array[pos + front] = value;

	    for (int i = rear - 1; i > pos + front; i--) {
		array[i + 1] = array[i];
	    }

	    array[pos + front + 1] = temp;

	    rear++;
	}
    }

    // ==============================================
    // delStart
    // ==============================================

    @Override
    public int delStart() {
	if (size() == 0) {
	    throw new ListIsEmptyException();
	}

	front++;
	return size();
    }

    // ==============================================
    // delEnd
    // ==============================================

    @Override
    public int delEnd() {
	if (size() == 0) {
	    throw new ListIsEmptyException();
	}

	rear--;
	return size();
    }

    // ==============================================
    // delPos
    // ==============================================
    @Override
    public int delPos(int pos) {
	if (size() == 0) {
	    throw new ListIsEmptyException();
	}

	if (pos < 0 || pos >= size()) {
	    throw new ListIsEmptyException();
	}

	for (int i = pos + front; i < rear; i++) {
	    array[i] = array[i + 1];
	}

	rear--;
	return pos;
    }

    // ==============================================
    // min
    // ==============================================

    @Override
    public int min() {
	int min;

	if (size() == 0) {
	    throw new ListIsEmptyException();
	} else {
	    min = array[front];
	}

	for (int i = front; i < rear; i++) {
	    if (min > array[i]) {
		min = array[i];
	    }
	}

	return min;
    }

    // ==============================================
    // max
    // ==============================================

    @Override
    public int max() {
	int max;

	if (size() == 0) {
	    throw new ListIsEmptyException();
	} else {
	    max = array[front];
	}

	for (int i = front; i < rear; i++) {
	    if (max < array[i]) {
		max = array[i];
	    }
	}

	return max;
    }
    // ==============================================
    // minInd
    // ==============================================

    @Override
    public int minInd() {
	int minVal;

	if (size() == 0) {
	    throw new ListIsEmptyException();
	} else {
	    minVal = array[front];
	}

	int minInd = front;

	for (int i = front; i < rear; i++) {
	    if (minVal > array[i]) {
		minVal = array[i];
		minInd = i;
	    }
	}

	minInd -= front;

	return minInd;
    }

    // ==============================================
    // maxInd
    // ==============================================
    @Override
    public int maxInd() {
	int maxVal;

	if (size() == 0) {
	    throw new ListIsEmptyException();
	} else {
	    maxVal = array[front];
	}

	int maxInd = front;

	for (int i = front; i < rear; i++) {
	    if (maxVal < array[i]) {
		maxVal = array[i];
		maxInd = i;
	    }
	}

	maxInd -= front;

	return maxInd;
    }

    // ==============================================
    // reverse
    // ==============================================

    @Override
    public void reverse() {
	int counter = rear - 1;

	for (int i = front; i < front + size() / 2; i++) {
	    if (i != counter && i < counter) {
		int temp = array[counter];
		array[counter] = array[i];
		array[i] = temp;
		counter--;
	    }
	}
    }
    //==============================================
  	//halfReverse
  	//==============================================

    @Override
    public void halfReverse() {
	int partLength = front + (size() / 2);

	if (size() % 2 == 0) {
	    for (int i = front, j = 0; i < partLength; i++, j++) {
		int temp = array[i];
		array[i] = array[partLength + j];
		array[partLength + j] = temp;
	    }
	} else {
	    for (int i = front, j = 0; i < partLength; i++, j++) {
		int temp = array[i];
		array[i] = array[partLength + j + 1];
		array[partLength + j + 1] = temp;
	    }
	}
    }

    // ==============================================
    // sort
    // ==============================================
    @Override
    public void sort() {
	for (int i = rear - 1; i >= front; i--) {
	    for (int j = front; j < i; j++) {
		if (array[j] > array[j + 1]) {
		    int temp = array[j];
		    array[j] = array[j + 1];
		    array[j + 1] = temp;
		}
	    }
	}

    }

    @Override
    public void clear() {
	front = array.length / 2;
	rear = front;
    }

    @Override
    public void set(int pos, int val) {
	if ((rear - front) == 0)
	    throw new ListIsEmptyException();
	array[front + pos] = val;

    }

    public int get(int pos) {
	if ((rear - front) == 0)
	    throw new ListIsEmptyException();
	return array[front + pos];
    }

    private void resize() {
	int[] newArray = new int[array.length + ((array.length / 100) * 20)];
	array = newArray;
    }

    private void sizeControl() {
	while (size() >= array.length) {
	    resize();
	}
    }

    private void balance() {
	int[] tempArray = array;
	int newFront = (array.length - size()) / 2;
	int newRear = newFront + size();

	for (int i = front, j = 0; i < rear - 1; i++, j++) {
	    array[newFront + j] = tempArray[i];
	}

	front = newFront;
	rear = newRear;
    }

}