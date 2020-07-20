// Generated code from Butter Knife. Do not modify!
package com.nef3001.NEFurnitAR;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class cart_activity_ViewBinding implements Unbinder {
  private cart_activity target;

  @UiThread
  public cart_activity_ViewBinding(cart_activity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public cart_activity_ViewBinding(cart_activity target, View source) {
    this.target = target;

    target.toolBar = Utils.findRequiredViewAsType(source, R.id.toolbar_cart, "field 'toolBar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    cart_activity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolBar = null;
  }
}
