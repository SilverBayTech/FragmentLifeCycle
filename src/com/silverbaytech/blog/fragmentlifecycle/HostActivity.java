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

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HostActivity extends FragmentActivity
{
	private static final String TAG = "HostActivity";

	private Button addButton;
	private Button pushButton;
	private Button popButton;
	private Button removeButton;

	public HostActivity()
	{
		Log.i(TAG, "constructor");
	}

	@Override
	protected void onCreate(Bundle bundle)
	{
		Log.i(TAG, "onCreate enter");
		super.onCreate(bundle);
		Log.i(TAG, "super.onCreate done");
		setContentView(R.layout.activity_host);
		Log.i(TAG, "setContentView done");

		addButton = (Button) findViewById(R.id.addButton);
		removeButton = (Button) findViewById(R.id.removeButton);
		pushButton = (Button) findViewById(R.id.pushButton);
		popButton = (Button) findViewById(R.id.popButton);

		addButton.setOnClickListener(new AddClickListener());
		removeButton.setOnClickListener(new RemoveClickListener());
		pushButton.setOnClickListener(new PushClickListener());
		popButton.setOnClickListener(new PopClickListener());

		getSupportFragmentManager().addOnBackStackChangedListener(new BackStackListener());

		Log.i(TAG, "onCreate exit");
	}

	@Override
	protected void onDestroy()
	{
		Log.i(TAG, "onDestroy enter");
		super.onDestroy();
		Log.i(TAG, "onDestroy exit");
	}

	@Override
	protected void onPause()
	{
		Log.i(TAG, "onPause enter");
		super.onPause();
		Log.i(TAG, "onPause exit");
	}

	@Override
	protected void onResume()
	{
		Log.i(TAG, "onResume enter");
		super.onResume();
		Log.i(TAG, "onResume exit");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState)
	{
		Log.i(TAG, "onSaveInstanceState enter");
		super.onSaveInstanceState(outState);
		Log.i(TAG, "onSaveInstanceState exit");
	}

	@Override
	protected void onStart()
	{
		Log.i(TAG, "onStart enter");
		super.onStart();
		Log.i(TAG, "onStart exit");
	}

	@Override
	protected void onStop()
	{
		Log.i(TAG, "onStop enter");
		super.onStop();
		Log.i(TAG, "onStop exit");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState)
	{
		Log.i(TAG, "onRestoreInstanceState enter");
		super.onRestoreInstanceState(savedInstanceState);
		Log.i(TAG, "onRestoreInstanceState exit");
	}

	private class AddClickListener implements OnClickListener
	{
		@Override
		public void onClick(View v)
		{
			AddedFragment fragment = new AddedFragment();

			FragmentTransaction ft = HostActivity.this.getSupportFragmentManager()
				.beginTransaction();
			Log.i(TAG, "Adding fragment");
			ft.add(R.id.lowerContainer, fragment, "AddedFragment");
			Log.i(TAG, "Committing transaction");
			ft.commit();
			Log.i(TAG, "Committed transaction");

			HostActivity.this.addButton.setVisibility(View.GONE);
			HostActivity.this.pushButton.setVisibility(View.GONE);
			HostActivity.this.removeButton.setVisibility(View.VISIBLE);
			HostActivity.this.popButton.setVisibility(View.GONE);
		}
	}

	private class PushClickListener implements OnClickListener
	{
		@Override
		public void onClick(View v)
		{
			AddedFragment fragment = new AddedFragment();

			FragmentTransaction ft = HostActivity.this.getSupportFragmentManager()
				.beginTransaction();
			Log.i(TAG, "Adding fragment");
			ft.add(R.id.lowerContainer, fragment, "AddedFragment");
			Log.i(TAG, "Add to back stack");
			ft.addToBackStack("AddedFragmentToStack");
			Log.i(TAG, "Committing transaction");
			ft.commit();
			Log.i(TAG, "Committed transaction");

			HostActivity.this.addButton.setVisibility(View.GONE);
			HostActivity.this.pushButton.setVisibility(View.GONE);
			HostActivity.this.removeButton.setVisibility(View.GONE);
			HostActivity.this.popButton.setVisibility(View.VISIBLE);
		}
	}

	private class RemoveClickListener implements OnClickListener
	{
		@Override
		public void onClick(View v)
		{
			FragmentManager fm = HostActivity.this.getSupportFragmentManager();
			AddedFragment fragment = (AddedFragment) fm.findFragmentByTag("AddedFragment");
			FragmentTransaction ft = fm.beginTransaction();
			Log.i(TAG, "Removing fragment");
			ft.remove(fragment);
			Log.i(TAG, "Committing transaction");
			ft.commit();
			Log.i(TAG, "Committed transaction");

			HostActivity.this.addButton.setVisibility(View.VISIBLE);
			HostActivity.this.pushButton.setVisibility(View.VISIBLE);
			HostActivity.this.removeButton.setVisibility(View.GONE);
			HostActivity.this.popButton.setVisibility(View.GONE);
		}
	}

	private class PopClickListener implements OnClickListener
	{
		@Override
		public void onClick(View v)
		{
			FragmentManager fm = HostActivity.this.getSupportFragmentManager();
			Log.i(TAG, "Popping back stack");
			fm.popBackStack();
			Log.i(TAG, "Popped back stack");
		}
	}

	private class BackStackListener implements OnBackStackChangedListener
	{
		@Override
		public void onBackStackChanged()
		{
			Log.i(TAG, "onBackStackChanged");

			FragmentManager fm = HostActivity.this.getSupportFragmentManager();
			if (fm.getBackStackEntryCount() == 0)
			{
				Log.i(TAG, "back stack empty");
				HostActivity.this.addButton.setVisibility(View.VISIBLE);
				HostActivity.this.pushButton.setVisibility(View.VISIBLE);
				HostActivity.this.removeButton.setVisibility(View.GONE);
				HostActivity.this.popButton.setVisibility(View.GONE);
			}
		}
	}
}
