/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.support.v7.widget.AppCompatAutoCompleteTextView
 *  android.text.Editable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ArrayAdapter
 *  android.widget.ListAdapter
 *  java.lang.CharSequence
 */
package com.becandid.candid.views;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class AlwaysOnAutoCompleteView
extends AppCompatAutoCompleteTextView {
    public AlwaysOnAutoCompleteView(Context context) {
        super(context);
    }

    public AlwaysOnAutoCompleteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlwaysOnAutoCompleteView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    public boolean enoughToFilter() {
        return true;
    }

    protected void onFocusChanged(boolean bl2, int n2, Rect rect) {
        super.onFocusChanged(bl2, n2, rect);
        if (bl2 && this.getAdapter() != null) {
            this.performFiltering((CharSequence)this.getText(), 0);
        }
    }

    public void performCompletion() {
        if (this.isPopupShowing()) {
            (ArrayAdapter)this.getAdapter();
            this.getOnItemClickListener().onItemClick(null, null, 0, 0);
        }
    }
}

