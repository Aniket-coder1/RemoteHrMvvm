package com.example.mvvm;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.mvvm.databinding.FragmentContactBindingImpl;
import com.example.mvvm.databinding.FragmentDashboardBindingImpl;
import com.example.mvvm.databinding.FragmentReimbursementBindingImpl;
import com.example.mvvm.databinding.LeaveFagmentBindingImpl;
import com.example.mvvm.databinding.MainLoginBindingImpl;
import com.example.mvvm.databinding.SingleItmContactBindingImpl;
import com.example.mvvm.databinding.SingleItmLeaveListBindingImpl;
import com.example.mvvm.databinding.SingleItmReimbListBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTCONTACT = 1;

  private static final int LAYOUT_FRAGMENTDASHBOARD = 2;

  private static final int LAYOUT_FRAGMENTREIMBURSEMENT = 3;

  private static final int LAYOUT_LEAVEFAGMENT = 4;

  private static final int LAYOUT_MAINLOGIN = 5;

  private static final int LAYOUT_SINGLEITMCONTACT = 6;

  private static final int LAYOUT_SINGLEITMLEAVELIST = 7;

  private static final int LAYOUT_SINGLEITMREIMBLIST = 8;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(8);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mvvm.R.layout.fragment_contact, LAYOUT_FRAGMENTCONTACT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mvvm.R.layout.fragment_dashboard, LAYOUT_FRAGMENTDASHBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mvvm.R.layout.fragment_reimbursement, LAYOUT_FRAGMENTREIMBURSEMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mvvm.R.layout.leave_fagment, LAYOUT_LEAVEFAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mvvm.R.layout.main_login, LAYOUT_MAINLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mvvm.R.layout.single_itm_contact, LAYOUT_SINGLEITMCONTACT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mvvm.R.layout.single_itm_leave_list, LAYOUT_SINGLEITMLEAVELIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mvvm.R.layout.single_itm_reimb_list, LAYOUT_SINGLEITMREIMBLIST);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTCONTACT: {
          if ("layout/fragment_contact_0".equals(tag)) {
            return new FragmentContactBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_contact is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTDASHBOARD: {
          if ("layout/fragment_dashboard_0".equals(tag)) {
            return new FragmentDashboardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_dashboard is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREIMBURSEMENT: {
          if ("layout/fragment_reimbursement_0".equals(tag)) {
            return new FragmentReimbursementBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_reimbursement is invalid. Received: " + tag);
        }
        case  LAYOUT_LEAVEFAGMENT: {
          if ("layout/leave_fagment_0".equals(tag)) {
            return new LeaveFagmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for leave_fagment is invalid. Received: " + tag);
        }
        case  LAYOUT_MAINLOGIN: {
          if ("layout/main_login_0".equals(tag)) {
            return new MainLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for main_login is invalid. Received: " + tag);
        }
        case  LAYOUT_SINGLEITMCONTACT: {
          if ("layout/single_itm_contact_0".equals(tag)) {
            return new SingleItmContactBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for single_itm_contact is invalid. Received: " + tag);
        }
        case  LAYOUT_SINGLEITMLEAVELIST: {
          if ("layout/single_itm_leave_list_0".equals(tag)) {
            return new SingleItmLeaveListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for single_itm_leave_list is invalid. Received: " + tag);
        }
        case  LAYOUT_SINGLEITMREIMBLIST: {
          if ("layout/single_itm_reimb_list_0".equals(tag)) {
            return new SingleItmReimbListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for single_itm_reimb_list is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(11);

    static {
      sKeys.put(1, "ContactList");
      sKeys.put(2, "ContactListData");
      sKeys.put(3, "Dashboard");
      sKeys.put(4, "Leave");
      sKeys.put(5, "LeaveList");
      sKeys.put(6, "ReimburseListData");
      sKeys.put(7, "Reimbursement");
      sKeys.put(0, "_all");
      sKeys.put(8, "leaveListData");
      sKeys.put(9, "leaveListView");
      sKeys.put(10, "loginViewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(8);

    static {
      sKeys.put("layout/fragment_contact_0", com.example.mvvm.R.layout.fragment_contact);
      sKeys.put("layout/fragment_dashboard_0", com.example.mvvm.R.layout.fragment_dashboard);
      sKeys.put("layout/fragment_reimbursement_0", com.example.mvvm.R.layout.fragment_reimbursement);
      sKeys.put("layout/leave_fagment_0", com.example.mvvm.R.layout.leave_fagment);
      sKeys.put("layout/main_login_0", com.example.mvvm.R.layout.main_login);
      sKeys.put("layout/single_itm_contact_0", com.example.mvvm.R.layout.single_itm_contact);
      sKeys.put("layout/single_itm_leave_list_0", com.example.mvvm.R.layout.single_itm_leave_list);
      sKeys.put("layout/single_itm_reimb_list_0", com.example.mvvm.R.layout.single_itm_reimb_list);
    }
  }
}
