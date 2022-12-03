package com.example.mvvm.databinding;
import com.example.mvvm.R;
import com.example.mvvm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class SingleItmReimbListBindingImpl extends SingleItmReimbListBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvLeaveType, 1);
        sViewsWithIds.put(R.id.rl1, 2);
        sViewsWithIds.put(R.id.ivIcon, 3);
        sViewsWithIds.put(R.id.tvStatus, 4);
        sViewsWithIds.put(R.id.tvReason, 5);
        sViewsWithIds.put(R.id.tvLeaveFrom, 6);
        sViewsWithIds.put(R.id.tvApprovedBy, 7);
        sViewsWithIds.put(R.id.ivDelete, 8);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public SingleItmReimbListBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private SingleItmReimbListBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[4]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.ReimburseListData == variableId) {
            setReimburseListData((com.example.mvvm.dataClass.ReimburseListData) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setReimburseListData(@Nullable com.example.mvvm.dataClass.ReimburseListData ReimburseListData) {
        this.mReimburseListData = ReimburseListData;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): ReimburseListData
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}