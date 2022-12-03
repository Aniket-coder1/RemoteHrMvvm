package com.example.mvvm.databinding;
import com.example.mvvm.R;
import com.example.mvvm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentContactBindingImpl extends FragmentContactBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rvContact, 2);
    }
    // views
    @Nullable
    private final com.example.mvvm.databinding.CustomToolbarBinding mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView01;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentContactBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private FragmentContactBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            );
        this.mboundView0 = (bindings[1] != null) ? com.example.mvvm.databinding.CustomToolbarBinding.bind((android.view.View) bindings[1]) : null;
        this.mboundView01 = (android.widget.LinearLayout) bindings[0];
        this.mboundView01.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.ContactList == variableId) {
            setContactList((com.example.mvvm.contact.ContactViewModel) variable);
        }
        else if (BR.LeaveList == variableId) {
            setLeaveList((com.example.mvvm.liveList.LeaveListViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setContactList(@Nullable com.example.mvvm.contact.ContactViewModel ContactList) {
        this.mContactList = ContactList;
    }
    public void setLeaveList(@Nullable com.example.mvvm.liveList.LeaveListViewModel LeaveList) {
        this.mLeaveList = LeaveList;
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
        flag 0 (0x1L): ContactList
        flag 1 (0x2L): LeaveList
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}