package com.example.mvvm.databinding;
import com.example.mvvm.R;
import com.example.mvvm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentDashboardBindingImpl extends FragmentDashboardBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 1);
        sViewsWithIds.put(R.id.tvWelcome, 2);
        sViewsWithIds.put(R.id.tvClockIn, 3);
        sViewsWithIds.put(R.id.tvClockOut, 4);
        sViewsWithIds.put(R.id.cvPunchIn, 5);
        sViewsWithIds.put(R.id.cvPunchOut, 6);
        sViewsWithIds.put(R.id.ivTime, 7);
        sViewsWithIds.put(R.id.tvDate, 8);
        sViewsWithIds.put(R.id.tvHelp, 9);
        sViewsWithIds.put(R.id.recyclerView, 10);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentDashboardBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private FragmentDashboardBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[5]
            , (androidx.cardview.widget.CardView) bindings[6]
            , (android.widget.ImageView) bindings[7]
            , (androidx.recyclerview.widget.RecyclerView) bindings[10]
            , (bindings[1] != null) ? com.example.mvvm.databinding.CustomToolbarBinding.bind((android.view.View) bindings[1]) : null
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
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
        if (BR.Dashboard == variableId) {
            setDashboard((com.example.mvvm.dashBoard.DashboardViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setDashboard(@Nullable com.example.mvvm.dashBoard.DashboardViewModel Dashboard) {
        this.mDashboard = Dashboard;
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
        flag 0 (0x1L): Dashboard
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}