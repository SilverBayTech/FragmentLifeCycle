/*
 * Copyright (c) 2014 Kevin Hunter
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.silverbaytech.blog.fragmentlifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HostedFragment extends Fragment
{
	public static final String TAG = "HostedFragment";

	public HostedFragment()
	{
		Log.i(TAG, "constructor");
	}

	@Override
	public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState)
	{
		Log.i(TAG, "onInflate enter");
		super.onInflate(activity, attrs, savedInstanceState);
		Log.i(TAG, "onInflate exit");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		Log.i(TAG, "onCreateView enter");
		View view = inflater.inflate(R.layout.fragment_hosted, container, false);
		Log.i(TAG, "onCreateView exit");
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		Log.i(TAG, "onActivityCreated enter");
		super.onActivityCreated(savedInstanceState);
		Log.i(TAG, "onActivityCreated exit");
	}

	@Override
	public void onAttach(Activity activity)
	{
		Log.i(TAG, "onAttach enter");
		super.onAttach(activity);
		Log.i(TAG, "onAttach exit");
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		Log.i(TAG, "onCreate enter");
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null)
		{
			String tag = savedInstanceState.getString("tag");
			Log.i(TAG, "savedInstanceState.tag=" + (tag == null?"null":tag));
		}
		else
		{
			Log.i(TAG, "savedInstanceState is null");
		}
		Log.i(TAG, "onCreate exit");
	}

	@Override
	public void onDestroy()
	{
		Log.i(TAG, "onDestroy enter");
		super.onDestroy();
		Log.i(TAG, "onDestroy exit");
	}

	@Override
	public void onDestroyView()
	{
		Log.i(TAG, "onDestroyView enter");
		super.onDestroyView();
		Log.i(TAG, "onDestroyView exit");
	}

	@Override
	public void onDetach()
	{
		Log.i(TAG, "onDetach enter");
		super.onDetach();
		Log.i(TAG, "onDetach exit");
	}

	@Override
	public void onPause()
	{
		Log.i(TAG, "onPause enter");
		super.onPause();
		Log.i(TAG, "onPause exit");
	}

	@Override
	public void onResume()
	{
		Log.i(TAG, "onResume enter");
		super.onResume();
		Log.i(TAG, "onResume exit");
	}

	@Override
	public void onViewStateRestored(Bundle savedInstanceState)
	{
		Log.i(TAG, "onViewStateRestored enter");
		super.onViewStateRestored(savedInstanceState);
		Log.i(TAG, "onViewStateRestored exit");
	}

	@Override
	public void onSaveInstanceState(Bundle outState)
	{
		Log.i(TAG, "onSaveInstanceState enter");
		super.onSaveInstanceState(outState);
		outState.putString("tag", TAG);
		Log.i(TAG, "onSaveInstanceState exit");
	}

	@Override
	public void onStart()
	{
		Log.i(TAG, "onStart enter");
		super.onStart();
		Log.i(TAG, "onStart exit");
	}

	@Override
	public void onStop()
	{
		Log.i(TAG, "onStop enter");
		super.onStop();
		Log.i(TAG, "onStop exit");
	}

}
