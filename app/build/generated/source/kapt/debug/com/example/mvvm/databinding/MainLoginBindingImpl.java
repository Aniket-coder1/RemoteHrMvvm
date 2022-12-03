package com.example.mvvm.databinding;
import com.example.mvvm.R;
import com.example.mvvm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class MainLoginBindingImpl extends MainLoginBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.btLogin, 4);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener ckRememberandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of loginViewModel.rememberMe.getValue()
            //         is loginViewModel.rememberMe.setValue((java.lang.Boolean) callbackArg_0)
            boolean callbackArg_0 = ckRemember.isChecked();
            // localize variables for thread safety
            // loginViewModel != null
            boolean loginViewModelJavaLangObjectNull = false;
            // loginViewModel.rememberMe != null
            boolean loginViewModelRememberMeJavaLangObjectNull = false;
            // loginViewModel.rememberMe
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> loginViewModelRememberMe = null;
            // loginViewModel.rememberMe.getValue()
            java.lang.Boolean loginViewModelRememberMeGetValue = null;
            // loginViewModel
            com.example.mvvm.mainLogin.LoginViewModel loginViewModel = mLoginViewModel;



            loginViewModelJavaLangObjectNull = (loginViewModel) != (null);
            if (loginViewModelJavaLangObjectNull) {


                loginViewModelRememberMe = loginViewModel.getRememberMe();

                loginViewModelRememberMeJavaLangObjectNull = (loginViewModelRememberMe) != (null);
                if (loginViewModelRememberMeJavaLangObjectNull) {




                    loginViewModelRememberMe.setValue(((java.lang.Boolean) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener userIdandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of loginViewModel.inputPassword.getValue()
            //         is loginViewModel.inputPassword.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(userId);
            // localize variables for thread safety
            // loginViewModel != null
            boolean loginViewModelJavaLangObjectNull = false;
            // loginViewModel.inputPassword != null
            boolean loginViewModelInputPasswordJavaLangObjectNull = false;
            // loginViewModel.inputPassword.getValue()
            java.lang.String loginViewModelInputPasswordGetValue = null;
            // loginViewModel.inputPassword
            androidx.lifecycle.MutableLiveData<java.lang.String> loginViewModelInputPassword = null;
            // loginViewModel
            com.example.mvvm.mainLogin.LoginViewModel loginViewModel = mLoginViewModel;



            loginViewModelJavaLangObjectNull = (loginViewModel) != (null);
            if (loginViewModelJavaLangObjectNull) {


                loginViewModelInputPassword = loginViewModel.getInputPassword();

                loginViewModelInputPasswordJavaLangObjectNull = (loginViewModelInputPassword) != (null);
                if (loginViewModelInputPasswordJavaLangObjectNull) {




                    loginViewModelInputPassword.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener userNameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of loginViewModel.inputUserId.getValue()
            //         is loginViewModel.inputUserId.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(userName);
            // localize variables for thread safety
            // loginViewModel != null
            boolean loginViewModelJavaLangObjectNull = false;
            // loginViewModel.inputUserId
            androidx.lifecycle.MutableLiveData<java.lang.String> loginViewModelInputUserId = null;
            // loginViewModel.inputUserId != null
            boolean loginViewModelInputUserIdJavaLangObjectNull = false;
            // loginViewModel.inputUserId.getValue()
            java.lang.String loginViewModelInputUserIdGetValue = null;
            // loginViewModel
            com.example.mvvm.mainLogin.LoginViewModel loginViewModel = mLoginViewModel;



            loginViewModelJavaLangObjectNull = (loginViewModel) != (null);
            if (loginViewModelJavaLangObjectNull) {


                loginViewModelInputUserId = loginViewModel.getInputUserId();

                loginViewModelInputUserIdJavaLangObjectNull = (loginViewModelInputUserId) != (null);
                if (loginViewModelInputUserIdJavaLangObjectNull) {




                    loginViewModelInputUserId.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public MainLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private MainLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.Button) bindings[4]
            , (android.widget.CheckBox) bindings[3]
            , (android.widget.EditText) bindings[2]
            , (android.widget.EditText) bindings[1]
            );
        this.ckRemember.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.userId.setTag(null);
        this.userName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
        if (BR.loginViewModel == variableId) {
            setLoginViewModel((com.example.mvvm.mainLogin.LoginViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setLoginViewModel(@Nullable com.example.mvvm.mainLogin.LoginViewModel LoginViewModel) {
        this.mLoginViewModel = LoginViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.loginViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeLoginViewModelRememberMe((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
            case 1 :
                return onChangeLoginViewModelInputUserId((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeLoginViewModelInputPassword((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLoginViewModelRememberMe(androidx.lifecycle.MutableLiveData<java.lang.Boolean> LoginViewModelRememberMe, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLoginViewModelInputUserId(androidx.lifecycle.MutableLiveData<java.lang.String> LoginViewModelInputUserId, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLoginViewModelInputPassword(androidx.lifecycle.MutableLiveData<java.lang.String> LoginViewModelInputPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> loginViewModelRememberMe = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxLoginViewModelRememberMeGetValue = false;
        java.lang.Boolean loginViewModelRememberMeGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> loginViewModelInputUserId = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> loginViewModelInputPassword = null;
        java.lang.String loginViewModelInputUserIdGetValue = null;
        java.lang.String loginViewModelInputPasswordGetValue = null;
        com.example.mvvm.mainLogin.LoginViewModel loginViewModel = mLoginViewModel;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (loginViewModel != null) {
                        // read loginViewModel.rememberMe
                        loginViewModelRememberMe = loginViewModel.getRememberMe();
                    }
                    updateLiveDataRegistration(0, loginViewModelRememberMe);


                    if (loginViewModelRememberMe != null) {
                        // read loginViewModel.rememberMe.getValue()
                        loginViewModelRememberMeGetValue = loginViewModelRememberMe.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(loginViewModel.rememberMe.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxLoginViewModelRememberMeGetValue = androidx.databinding.ViewDataBinding.safeUnbox(loginViewModelRememberMeGetValue);
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (loginViewModel != null) {
                        // read loginViewModel.inputUserId
                        loginViewModelInputUserId = loginViewModel.getInputUserId();
                    }
                    updateLiveDataRegistration(1, loginViewModelInputUserId);


                    if (loginViewModelInputUserId != null) {
                        // read loginViewModel.inputUserId.getValue()
                        loginViewModelInputUserIdGetValue = loginViewModelInputUserId.getValue();
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (loginViewModel != null) {
                        // read loginViewModel.inputPassword
                        loginViewModelInputPassword = loginViewModel.getInputPassword();
                    }
                    updateLiveDataRegistration(2, loginViewModelInputPassword);


                    if (loginViewModelInputPassword != null) {
                        // read loginViewModel.inputPassword.getValue()
                        loginViewModelInputPasswordGetValue = loginViewModelInputPassword.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.ckRemember, androidxDatabindingViewDataBindingSafeUnboxLoginViewModelRememberMeGetValue);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.ckRemember, (android.widget.CompoundButton.OnCheckedChangeListener)null, ckRememberandroidCheckedAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.userId, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, userIdandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.userName, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, userNameandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.userId, loginViewModelInputPasswordGetValue);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.userName, loginViewModelInputUserIdGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): loginViewModel.rememberMe
        flag 1 (0x2L): loginViewModel.inputUserId
        flag 2 (0x3L): loginViewModel.inputPassword
        flag 3 (0x4L): loginViewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}