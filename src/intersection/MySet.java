package intersection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet<V> implements Set<V> {
    private V[] values;
    private int[] indexes;

    public MySet(int size) {
        values = (V[]) new Object[size];
        indexes = new int[size];
        Arrays.fill(indexes, -1);
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean contains(Object o) {
        if (o != null) {
            int hashCode = getHashCode(o);

            if (values[hashCode].equals(o)) {
                return true;
            }
            int index = hashCode;
            int count = 0;
            while (indexes[index] != -1 && count++ < values.length) {
                index = indexes[index];

                if (values[index].equals(o)) {
                    return true;
                }
            }
            if (count >= values.length) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean add(V v) {
        int hashCode = getHashCode(v);
        if (values[hashCode] == null) {
            values[hashCode] = v;
            return true;
        }
        if (getHashCode(values[hashCode]) != hashCode) {
            this.moveElement(hashCode, v);
            return true;
        }
        int index = hashCode;
        int count = 0;
        while (indexes[index] != -1 && count++ < values.length) {
            index = indexes[index];
        }
        if (count >= size()) {
            return false;
        }
        indexes[index] = findEmptyIndex(index);
        values[indexes[index]] = v;

        return true;
    }

    private int findEmptyIndex(int from) {
        for (int i = from % size(); i < size(); i++) {
            if (values[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private int getHashCode(Object element) {
        int hash = element.hashCode();
        return Math.abs(hash) % size();
    }

    private void moveElement(int hash, V v) {
        V oldValue = values[hash];
        int oldIndex = indexes[hash];
        values[hash] = v;
        indexes[hash] = -1;

        int newIndex = findEmptyIndex(hash);
        indexes[getIndexPrevElement(oldValue)] = newIndex;
        values[newIndex] = oldValue;
        indexes[newIndex] = oldIndex;
    }

    private int getIndexPrevElement(V oldValue) {
        int currentIndex = getHashCode(oldValue);
        while (values[indexes[currentIndex]] != oldValue) {
            currentIndex = indexes[currentIndex];
        }
        return currentIndex;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<V> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends V> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        values = (V[]) new Object[values.length];
        indexes = new int[indexes.length];
    }
}
