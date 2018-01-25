package com.babylonhealth.recruitment;

interface JLinkedList {
  int value();
  JLinkedList next();
  void setNext(JLinkedList next);
  int length() throws CyclicalException;
  boolean hasCycle();

  class CyclicalException extends RuntimeException {}
}

