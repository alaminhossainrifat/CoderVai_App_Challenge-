// Generated by view binder compiler. Do not edit!
package com.codervai.calculator.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.codervai.calculator.R;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton add;

  @NonNull
  public final MaterialButton allClear;

  @NonNull
  public final MaterialButton backspace;

  @NonNull
  public final GridLayout buttonsLayout;

  @NonNull
  public final MaterialButton cos;

  @NonNull
  public final MaterialButton divide;

  @NonNull
  public final MaterialButton dot;

  @NonNull
  public final MaterialButton eight;

  @NonNull
  public final MaterialButton equal;

  @NonNull
  public final TextView expression;

  @NonNull
  public final MaterialButton five;

  @NonNull
  public final MaterialButton four;

  @NonNull
  public final MaterialButton leftParenthesis;

  @NonNull
  public final LinearLayout modeButtons;

  @NonNull
  public final MaterialButton multiply;

  @NonNull
  public final MaterialButton nine;

  @NonNull
  public final MaterialButton one;

  @NonNull
  public final MaterialButton percent;

  @NonNull
  public final MaterialButton power;

  @NonNull
  public final MaterialButton rightParenthesis;

  @NonNull
  public final GridLayout scientificLayout;

  @NonNull
  public final MaterialButton scientificMode;

  @NonNull
  public final TextView screen;

  @NonNull
  public final MaterialButton seven;

  @NonNull
  public final MaterialButton sin;

  @NonNull
  public final MaterialButton six;

  @NonNull
  public final MaterialButton subtract;

  @NonNull
  public final MaterialButton switchToBasic;

  @NonNull
  public final MaterialButton tan;

  @NonNull
  public final MaterialButton three;

  @NonNull
  public final MaterialButton two;

  @NonNull
  public final MaterialButton zero;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull MaterialButton add,
      @NonNull MaterialButton allClear, @NonNull MaterialButton backspace,
      @NonNull GridLayout buttonsLayout, @NonNull MaterialButton cos,
      @NonNull MaterialButton divide, @NonNull MaterialButton dot, @NonNull MaterialButton eight,
      @NonNull MaterialButton equal, @NonNull TextView expression, @NonNull MaterialButton five,
      @NonNull MaterialButton four, @NonNull MaterialButton leftParenthesis,
      @NonNull LinearLayout modeButtons, @NonNull MaterialButton multiply,
      @NonNull MaterialButton nine, @NonNull MaterialButton one, @NonNull MaterialButton percent,
      @NonNull MaterialButton power, @NonNull MaterialButton rightParenthesis,
      @NonNull GridLayout scientificLayout, @NonNull MaterialButton scientificMode,
      @NonNull TextView screen, @NonNull MaterialButton seven, @NonNull MaterialButton sin,
      @NonNull MaterialButton six, @NonNull MaterialButton subtract,
      @NonNull MaterialButton switchToBasic, @NonNull MaterialButton tan,
      @NonNull MaterialButton three, @NonNull MaterialButton two, @NonNull MaterialButton zero) {
    this.rootView = rootView;
    this.add = add;
    this.allClear = allClear;
    this.backspace = backspace;
    this.buttonsLayout = buttonsLayout;
    this.cos = cos;
    this.divide = divide;
    this.dot = dot;
    this.eight = eight;
    this.equal = equal;
    this.expression = expression;
    this.five = five;
    this.four = four;
    this.leftParenthesis = leftParenthesis;
    this.modeButtons = modeButtons;
    this.multiply = multiply;
    this.nine = nine;
    this.one = one;
    this.percent = percent;
    this.power = power;
    this.rightParenthesis = rightParenthesis;
    this.scientificLayout = scientificLayout;
    this.scientificMode = scientificMode;
    this.screen = screen;
    this.seven = seven;
    this.sin = sin;
    this.six = six;
    this.subtract = subtract;
    this.switchToBasic = switchToBasic;
    this.tan = tan;
    this.three = three;
    this.two = two;
    this.zero = zero;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add;
      MaterialButton add = ViewBindings.findChildViewById(rootView, id);
      if (add == null) {
        break missingId;
      }

      id = R.id.all_clear;
      MaterialButton allClear = ViewBindings.findChildViewById(rootView, id);
      if (allClear == null) {
        break missingId;
      }

      id = R.id.backspace;
      MaterialButton backspace = ViewBindings.findChildViewById(rootView, id);
      if (backspace == null) {
        break missingId;
      }

      id = R.id.buttons_layout;
      GridLayout buttonsLayout = ViewBindings.findChildViewById(rootView, id);
      if (buttonsLayout == null) {
        break missingId;
      }

      id = R.id.cos;
      MaterialButton cos = ViewBindings.findChildViewById(rootView, id);
      if (cos == null) {
        break missingId;
      }

      id = R.id.divide;
      MaterialButton divide = ViewBindings.findChildViewById(rootView, id);
      if (divide == null) {
        break missingId;
      }

      id = R.id.dot;
      MaterialButton dot = ViewBindings.findChildViewById(rootView, id);
      if (dot == null) {
        break missingId;
      }

      id = R.id.eight;
      MaterialButton eight = ViewBindings.findChildViewById(rootView, id);
      if (eight == null) {
        break missingId;
      }

      id = R.id.equal;
      MaterialButton equal = ViewBindings.findChildViewById(rootView, id);
      if (equal == null) {
        break missingId;
      }

      id = R.id.expression;
      TextView expression = ViewBindings.findChildViewById(rootView, id);
      if (expression == null) {
        break missingId;
      }

      id = R.id.five;
      MaterialButton five = ViewBindings.findChildViewById(rootView, id);
      if (five == null) {
        break missingId;
      }

      id = R.id.four;
      MaterialButton four = ViewBindings.findChildViewById(rootView, id);
      if (four == null) {
        break missingId;
      }

      id = R.id.left_parenthesis;
      MaterialButton leftParenthesis = ViewBindings.findChildViewById(rootView, id);
      if (leftParenthesis == null) {
        break missingId;
      }

      id = R.id.mode_buttons;
      LinearLayout modeButtons = ViewBindings.findChildViewById(rootView, id);
      if (modeButtons == null) {
        break missingId;
      }

      id = R.id.multiply;
      MaterialButton multiply = ViewBindings.findChildViewById(rootView, id);
      if (multiply == null) {
        break missingId;
      }

      id = R.id.nine;
      MaterialButton nine = ViewBindings.findChildViewById(rootView, id);
      if (nine == null) {
        break missingId;
      }

      id = R.id.one;
      MaterialButton one = ViewBindings.findChildViewById(rootView, id);
      if (one == null) {
        break missingId;
      }

      id = R.id.percent;
      MaterialButton percent = ViewBindings.findChildViewById(rootView, id);
      if (percent == null) {
        break missingId;
      }

      id = R.id.power;
      MaterialButton power = ViewBindings.findChildViewById(rootView, id);
      if (power == null) {
        break missingId;
      }

      id = R.id.right_parenthesis;
      MaterialButton rightParenthesis = ViewBindings.findChildViewById(rootView, id);
      if (rightParenthesis == null) {
        break missingId;
      }

      id = R.id.scientific_layout;
      GridLayout scientificLayout = ViewBindings.findChildViewById(rootView, id);
      if (scientificLayout == null) {
        break missingId;
      }

      id = R.id.scientific_mode;
      MaterialButton scientificMode = ViewBindings.findChildViewById(rootView, id);
      if (scientificMode == null) {
        break missingId;
      }

      id = R.id.screen;
      TextView screen = ViewBindings.findChildViewById(rootView, id);
      if (screen == null) {
        break missingId;
      }

      id = R.id.seven;
      MaterialButton seven = ViewBindings.findChildViewById(rootView, id);
      if (seven == null) {
        break missingId;
      }

      id = R.id.sin;
      MaterialButton sin = ViewBindings.findChildViewById(rootView, id);
      if (sin == null) {
        break missingId;
      }

      id = R.id.six;
      MaterialButton six = ViewBindings.findChildViewById(rootView, id);
      if (six == null) {
        break missingId;
      }

      id = R.id.subtract;
      MaterialButton subtract = ViewBindings.findChildViewById(rootView, id);
      if (subtract == null) {
        break missingId;
      }

      id = R.id.switch_to_basic;
      MaterialButton switchToBasic = ViewBindings.findChildViewById(rootView, id);
      if (switchToBasic == null) {
        break missingId;
      }

      id = R.id.tan;
      MaterialButton tan = ViewBindings.findChildViewById(rootView, id);
      if (tan == null) {
        break missingId;
      }

      id = R.id.three;
      MaterialButton three = ViewBindings.findChildViewById(rootView, id);
      if (three == null) {
        break missingId;
      }

      id = R.id.two;
      MaterialButton two = ViewBindings.findChildViewById(rootView, id);
      if (two == null) {
        break missingId;
      }

      id = R.id.zero;
      MaterialButton zero = ViewBindings.findChildViewById(rootView, id);
      if (zero == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, add, allClear, backspace,
          buttonsLayout, cos, divide, dot, eight, equal, expression, five, four, leftParenthesis,
          modeButtons, multiply, nine, one, percent, power, rightParenthesis, scientificLayout,
          scientificMode, screen, seven, sin, six, subtract, switchToBasic, tan, three, two, zero);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
