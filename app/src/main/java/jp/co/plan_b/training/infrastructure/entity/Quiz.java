package jp.co.plan_b.training.infrastructure.entity;

import lombok.Data;

@Data
public class Quiz {

  private Integer id;
  private Integer term;
  private Integer ordernumber;
  private String problem;
  private Integer answer;
  private String choice_a;
  private String choice_b;
  private String choice_c;
  private String choice_d;
  private Integer is_img;

}
