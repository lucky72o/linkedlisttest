package com.babylonhealth.recruitment;

import java.util.NoSuchElementException;

class JNullNode implements JLinkedList {
  public static final JNullNode INSTANCE = new JNullNode();

  private JNullNode() {}

  @Override
  public int value() {
    throw new NoSuchElementException();
  }

  @Override
  public JLinkedList next() {
    throw new NoSuchElementException();
  }

  @Override
  public void setNext(JLinkedList next) {
    throw new NoSuchElementException();
  }

  @Override
  public int length() {
    return 0;
  }

  @Override
  public boolean hasCycle() {
    return false;
  }
}
