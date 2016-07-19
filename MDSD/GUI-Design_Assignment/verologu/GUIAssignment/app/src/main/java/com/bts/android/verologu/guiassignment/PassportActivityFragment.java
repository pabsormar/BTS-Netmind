package com.bts.android.verologu.guiassignment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

/**
 * A placeholder fragment containing a simple view.
 */
public class PassportActivityFragment extends Fragment implements PassportActions {

    public static final int PICK_IMAGE = 1;

    private boolean editModeEnabled;

    private View rootView;
    private ImageView pictureFront;
    private TextView title;
    private TextView name;
    private EditText nameEdit;
    private TextView surname;
    private EditText surnameEdit;
    private TextView nationality;
    private EditText nationalityEdit;
    private CheckBox uecitizenEdit;
    private ImageButton uploadPic;
    private ImageButton removePic;

    private Bitmap currentPictureFront;

    public PassportActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams
                .SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        if (savedInstanceState != null) {
            currentPictureFront = savedInstanceState.getParcelable("pic_front_bitmap");
            editModeEnabled = savedInstanceState.getBoolean("edit_mode_enabled");
        }

        rootView = inflater.inflate(R.layout.fragment_passport, container, false);
        findViews();
        updateTexts();
        setPassportData();
        addActions();
        swipeEditables();
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable("pic_front_bitmap", currentPictureFront);
        outState.putBoolean("edit_mode_enabled", editModeEnabled);
    }

    private void findViews() {
        pictureFront = (ImageView) rootView.findViewById(R.id.iv_passport_pic_front);
        title = (TextView) rootView.findViewById(R.id.tv_passport_title);
        name = (TextView) rootView.findViewById(R.id.tv_passport_name);
        nameEdit = (EditText) rootView.findViewById(R.id.et_passport_name);
        surname = (TextView) rootView.findViewById(R.id.tv_passport_surname);
        surnameEdit = (EditText) rootView.findViewById(R.id.et_passport_surname);
        nationality = (TextView) rootView.findViewById(R.id.tv_passport_nationality);
        nationalityEdit = (EditText) rootView.findViewById(R.id.et_passport_nationality);
        uecitizenEdit = (CheckBox) rootView.findViewById(R.id.cb_passport_ue_citizen);
        uploadPic = (ImageButton) rootView.findViewById(R.id.b_upload);
        removePic = (ImageButton) rootView.findViewById(R.id.b_clear);
    }

    private void updateTexts() {
        title.setText(R.string.title);
        name.setText(R.string.name_title);
        surname.setText(R.string.surname_title);
        nationality.setText(R.string.nationality_title);
        uecitizenEdit.setText(R.string.ue_citizen_title);

        if (currentPictureFront == null) {
            pictureFront.setImageResource(R.mipmap.ic_launcher);
        } else {
            pictureFront.setImageBitmap(currentPictureFront);
        }
    }

    private void setPassportData() {
        nameEdit.setText(R.string.name_data);
        surnameEdit.setText(R.string.surname_data);
        nationalityEdit.setText(R.string.nationality_data);
    }

    private void addActions() {
        uploadPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPicture();
            }
        });

        removePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPictureFront = null;
                pictureFront.setImageResource(R.mipmap.ic_launcher);
            }
        });
    }

    private void getPicture() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        photoPickerIntent.setType("image/*");
        photoPickerIntent.putExtra("crop", "true");
        photoPickerIntent.putExtra("return-data", true);
        //photoPickerIntent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        // ******** code for crop image
        photoPickerIntent.putExtra("aspectX", 0);
        photoPickerIntent.putExtra("aspectY", 0);
        photoPickerIntent.putExtra("outputX", 350);
        photoPickerIntent.putExtra("outputY", 350);
        startActivityForResult(photoPickerIntent, PICK_IMAGE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case PICK_IMAGE:
                if (resultCode == Activity.RESULT_OK) {
                    if (imageReturnedIntent != null) {
                        Bundle extras = imageReturnedIntent.getExtras();
                        if (extras != null) {
                            currentPictureFront = extras.getParcelable("data");
                            pictureFront.setImageBitmap(currentPictureFront);
                        }
                    }
                }
        }
    }

    @Override
    public void swipeEditMode() {
        editModeEnabled = !editModeEnabled;

        swipeEditables();
    }

    private void swipeEditables() {
        uploadPic.setVisibility(editModeEnabled ? View.VISIBLE : View.GONE);
        removePic.setVisibility(editModeEnabled ? View.VISIBLE : View.GONE);
        nameEdit.setEnabled(editModeEnabled);
        surnameEdit.setEnabled(editModeEnabled);
        nationalityEdit.setEnabled(editModeEnabled);
        uecitizenEdit.setEnabled(editModeEnabled);
    }
}
