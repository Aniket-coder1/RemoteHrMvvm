package com.example.mvvm.databinding;
import com.example.mvvm.R;
import com.example.mvvm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentReimbursementBindingImpl extends FragmentReimbursementBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.etFromDate, 5);
        sViewsWithIds.put(R.id.etToDate, 6);
        sViewsWithIds.put(R.id.btApply, 7);
        sViewsWithIds.put(R.id.btListLeave, 8);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    @Nullable
    private final com.example.mvvm.databinding.CustomToolbarBinding mboundView11;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener etAmountandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of Reimbursement.amount.getValue()
            //         is Reimbursement.amount.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etAmount);
            // localize variables for thread safety
            // Reimbursement != null
            boolean reimbursementJavaLangObjectNull = false;
            // Reimbursement.amount
            androidx.lifecycle.MutableLiveData<java.lang.String> reimbursementAmount = null;
            // Reimbursement
            com.example.mvvm.reimbursement.ReimbursementViewModel reimbursement = mReimbursement;
            // Reimbursement.amount.getValue()
            java.lang.String reimbursementAmountGetValue = null;
            // Reimbursement.amount != null
            boolean reimbursementAmountJavaLangObjectNull = false;



            reimbursementJavaLangObjectNull = (reimbursement) != (null);
            if (reimbursementJavaLangObjectNull) {


                reimbursementAmount = reimbursement.getAmount();

                reimbursementAmountJavaLangObjectNull = (reimbursementAmount) != (null);
                if (reimbursementAmountJavaLangObjectNull) {




                    reimbursementAmount.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener etPurposeandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of Reimbursement.purpose.getValue()
            //         is Reimbursement.purpose.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etPurpose);
            // localize variables for thread safety
            // Reimbursement != null
            boolean reimbursementJavaLangObjectNull = false;
            // Reimbursement.purpose.getValue()
            java.lang.String reimbursementPurposeGetValue = null;
            // Reimbursement.purpose != null
            boolean reimbursementPurposeJavaLangObjectNull = false;
            // Reimbursement
            com.example.mvvm.reimbursement.ReimbursementViewModel reimbursement = mReimbursement;
            // Reimbursement.purpose
            androidx.lifecycle.MutableLiveData<java.lang.String> reimbursementPurpose = null;



            reimbursementJavaLangObjectNull = (reimbursement) != (null);
            if (reimbursementJavaLangObjectNull) {


                reimbursementPurpose = reimbursement.getPurpose();

                reimbursementPurposeJavaLangObjectNull = (reimbursementPurpose) != (null);
                if (reimbursementPurposeJavaLangObjectNull) {




                    reimbursementPurpose.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentReimbursementBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FragmentReimbursementBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.Button) bindings[7]
            , (android.widget.Button) bindings[8]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[2]
            , (android.widget.EditText) bindings[6]
            );
        this.etAmount.setTag(null);
        this.etPurpose.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView11 = (bindings[4] != null) ? com.example.mvvm.databinding.CustomToolbarBinding.bind((android.view.View) bindings[4]) : null;
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.Reimbursement == variableId) {
            setReimbursement((com.example.mvvm.reimbursement.ReimbursementViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setReimbursement(@Nullable com.example.mvvm.reimbursement.ReimbursementViewModel Reimbursement) {
        this.mReimbursement = Reimbursement;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.Reimbursement);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeReimbursementPurpose((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeReimbursementAmount((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeReimbursementPurpose(androidx.lifecycle.MutableLiveData<java.lang.String> ReimbursementPurpose, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeReimbursementAmount(androidx.lifecycle.MutableLiveData<java.lang.String> ReimbursementAmount, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
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
        androidx.lifecycle.MutableLiveData<java.lang.String> reimbursementPurpose = null;
        java.lang.String reimbursementPurposeGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> reimbursementAmount = null;
        com.example.mvvm.reimbursement.ReimbursementViewModel reimbursement = mReimbursement;
        java.lang.String reimbursementAmountGetValue = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (reimbursement != null) {
                        // read Reimbursement.purpose
                        reimbursementPurpose = reimbursement.getPurpose();
                    }
                    updateLiveDataRegistration(0, reimbursementPurpose);


                    if (reimbursementPurpose != null) {
                        // read Reimbursement.purpose.getValue()
                        reimbursementPurposeGetValue = reimbursementPurpose.getValue();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (reimbursement != null) {
                        // read Reimbursement.amount
                        reimbursementAmount = reimbursement.getAmount();
                    }
                    updateLiveDataRegistration(1, reimbursementAmount);


                    if (reimbursementAmount != null) {
                        // read Reimbursement.amount.getValue()
                        reimbursementAmountGetValue = reimbursementAmount.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etAmount, reimbursementAmountGetValue);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etAmount, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etAmountandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etPurpose, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etPurposeandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etPurpose, reimbursementPurposeGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): Reimbursement.purpose
        flag 1 (0x2L): Reimbursement.amount
        flag 2 (0x3L): Reimbursement
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}