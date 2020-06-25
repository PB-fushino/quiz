package jp.co.plan_b.training.model.dto;

import java.util.Comparator;

public class CorrectComparator implements Comparator<Corrects> {

  @Override
  public int compare(Corrects p1, Corrects p2) {
    return p1.corrects < p2.corrects ? -1 : 1;
  }

}
