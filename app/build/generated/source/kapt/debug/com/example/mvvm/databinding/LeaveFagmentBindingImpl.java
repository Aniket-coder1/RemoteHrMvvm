package com.example.mvvm.databinding;
import com.example.mvvm.R;
import com.example.mvvm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LeaveFagmentBindingImpl extends LeaveFagmentBinding implements com.example.mvvm.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.etLeaveType, 6);
        sViewsWithIds.put(R.id.spLeaveType, 7);
        sViewsWithIds.put(R.id.etFromDate, 8);
        sViewsWithIds.put(R.id.etToDate, 9);
        sViewsWithIds.put(R.id.etFrmSessions, 10);
        sViewsWithIds.put(R.id.spFrmSessions, 11);
        sViewsWithIds.put(R.id.etToSessions, 12);
        sViewsWithIds.put(R.id.spToSessions, 13);
        sViewsWithIds.put(R.id.tvAdd, 14);
        sViewsWithIds.put(R.id.tvListLeave, 15);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    @Nullable
    private final com.example.mvvm.databinding.CustomToolbarBinding mboundView11;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener etContactandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of Leave.contact.getValue()
            //         is Leave.contact.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etContact);
            // localize variables for thread safety
            // Leave
            com.example.mvvm.leave.LeaveViewModel leave = mLeave;
            // Leave.contact
            androidx.lifecycle.MutableLiveData<java.lang.String> leaveContact = null;
            // Leave != null
            boolean leaveJavaLangObjectNull = false;
            // Leave.contact.getValue()
            java.lang.String leaveContactGetValue = null;
            // Leave.contact != null
            boolean leaveContactJavaLangObjectNull = false;



            leaveJavaLangObjectNull = (leave) != (null);
            if (leaveJavaLangObjectNull) {


                leaveContact = leave.getContact();

                leaveContactJavaLangObjectNull = (leaveContact) != (null);
                if (leaveContactJavaLangObjectNull) {




                    leaveContact.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener etReasonandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of Leave.reason.getValue()
            //         is Leave.reason.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etReason);
            // localize variables for thread safety
            // Leave
            com.example.mvvm.leave.LeaveViewModel leave = mLeave;
            // Leave != null
            boolean leaveJavaLangObjectNull = false;
            // Leave.reason
            androidx.lifecycle.MutableLiveData<java.lang.String> leaveReason = null;
            // Leave.reason.getValue()
            java.lang.String leaveReasonGetValue = null;
            // Leave.reason != null
            boolean leaveReasonJavaLangObjectNull = false;



            leaveJavaLangObjectNull = (leave) != (null);
            if (leaveJavaLangObjectNull) {


                leaveReason = leave.getReason();

                leaveReasonJavaLangObjectNull = (leaveReason) != (null);
                if (leaveReasonJavaLangObjectNull) {




                    leaveReason.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public LeaveFagmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private LeaveFagmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.Button) bindings[4]
            , (android.widget.EditText) bindings[2]
            , (android.widget.EditText) bindings[10]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[12]
            , (com.example.mvvm.fontClass.CustomSpinner) bindings[11]
            , (com.example.mvvm.fontClass.CustomSpinner) bindings[7]
            , (com.example.mvvm.fontClass.CustomSpinner) bindings[13]
            , (android.widget.TextView) bindings[14]
            , (android.widget.Button) bindings[15]
            );
        this.btok.setTag(null);
        this.etContact.setTag(null);
        this.etReason.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView11 = (bindings[5] != null) ? com.example.mvvm.databinding.CustomToolbarBinding.bind((android.view.View) bindings[5]) : null;
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.mvvm.generated.callback.OnClickListener(this, 1);
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
        if (BR.Leave == variableId) {
            setLeave((com.example.mvvm.leave.LeaveViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setLeave(@Nullable com.example.mvvm.leave.LeaveViewModel Leave) {
        this.mLeave = Leave;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.Leave);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeLeaveContact((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeLeaveReason((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLeaveContact(androidx.lifecycle.MutableLiveData<java.lang.String> LeaveContact, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLeaveReason(androidx.lifecycle.MutableLiveData<java.lang.String> LeaveReason, int fieldId) {
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
        androidx.lifecycle.MutableLiveData<java.lang.String> leaveContact = null;
        java.lang.String leaveReasonGetValue = null;
        com.example.mvvm.leave.LeaveViewModel leave = mLeave;
        androidx.lifecycle.MutableLiveData<java.lang.String> leaveReason = null;
        java.lang.String leaveContactGetValue = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (leave != null) {
                        // read Leave.contact
                        leaveContact = leave.getContact();
                    }
                    updateLiveDataRegistration(0, leaveContact);


                    if (leaveContact != null) {
                        // read Leave.contact.getValue()
                        leaveContactGetValue = leaveContact.getValue();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (leave != null) {
                        // read Leave.reason
                        leaveReason = leave.getReason();
                    }
                    updateLiveDataRegistration(1, leaveReason);


                    if (leaveReason != null) {
                        // read Leave.reason.getValue()
                        leaveReasonGetValue = leaveReason.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.btok.setOnClickListener(mCallback1);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etContact, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etContactandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etReason, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etReasonandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etContact, leaveContactGetValue);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etReason, leaveReasonGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // Leave
        com.example.mvvm.leave.LeaveViewModel leave = mLeave;
        // Leave != null
        boolean leaveJavaLangObjectNull = false;



        leaveJavaLangObjectNull = (leave) != (null);
        if (leaveJavaLangObjectNull) {


            leave.hitApply();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): Leave.contact
        flag 1 (0x2L): Leave.reason
        flag 2 (0x3L): Leave
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}