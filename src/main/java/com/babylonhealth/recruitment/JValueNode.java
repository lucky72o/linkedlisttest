package com.babylonhealth.recruitment;

class JValueNode implements JLinkedList {

  private int value;
  private JLinkedList next;

  public JValueNode(int value, JLinkedList tail) {
    this.value = value;
    this.next = tail;
  }

  public static JLinkedList create(int... values) {
    throw new UnsupportedOperationException();
  }

  @Override
  public int value() {
    throw new UnsupportedOperationException();
  }

  @Override
  public JLinkedList next() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setNext(JLinkedList next) {
    throw new UnsupportedOperationException();
  }

  @Override
  public int length() throws CyclicalException {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean hasCycle() {
    throw new UnsupportedOperationException();
  }
}
