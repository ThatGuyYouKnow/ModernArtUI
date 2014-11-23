package course.project.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MoreInfoFragment extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		View v = getActivity().getLayoutInflater().inflate(R.layout.dialog, null);
		
		return new AlertDialog.Builder(getActivity())
			.setView(v)
			//.setTitle(R.string.dialog_more_information_prompt)
			.setPositiveButton(R.string.dialog_more_information_ok, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Uri uri = Uri.parse("http://www.moma.org");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					startActivity(intent);
					
				}
			})
			.setNegativeButton(R.string.dialog_more_information_cancel, null)
			.create();
	}

}
