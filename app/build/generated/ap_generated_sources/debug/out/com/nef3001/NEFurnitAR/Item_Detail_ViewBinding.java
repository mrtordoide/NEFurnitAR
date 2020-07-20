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

public class Item_Detail_ViewBinding implements Unbinder {
  private Item_Detail target;

  @UiThread
  public Item_Detail_ViewBinding(Item_Detail target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Item_Detail_ViewBinding(Item_Detail target, View source) {
    this.target = target;

    target.toolBar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolBar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Item_Detail target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolBar = null;
  }
}
