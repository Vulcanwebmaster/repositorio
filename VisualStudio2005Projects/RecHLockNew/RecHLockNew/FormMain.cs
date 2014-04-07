using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Aladdin.HASP;

namespace RecHLockNew
{
    public partial class FormMain : Form
    {

        private Logger log = new Logger(typeof(FormMain));

        private HardLockHelper helper = new HardLockHelper();
        
        public FormMain()
        {
            InitializeComponent();
        }

        private void FormMain_Load(object sender, EventArgs e)
        {
            txtHardLockValido.Text = "HARDLOCK V�LIDO";
        }

        private void btnSair_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnLoginHasp_Click(object sender, EventArgs e)
        {

            HaspStatus status = helper.loginInHasp();

            if (HaspStatus.StatusOk == status)
            {
                helper.logoutInHasp();
            }

        }

        private void btnCmdWrite_Click(object sender, EventArgs e)
        {
            HaspStatus status;

            string msgaux = "";

            DateTime? validade = null;
            if (!chkIlimitado.Checked)
            {
                validade = Calendar.SelectionRange.Start;
            }

            if (!validaCampos()) return;

            HardLock hl = new HardLockBuilder()
                    .withVersaHardLock(Convert.ToInt32(txtVersaoHardLock.Text))
                    .withNCanais(Convert.ToInt32(txtNCanais.Text))
                    .withValidade(validade)
                    .withVMajor(Convert.ToInt32(txtVMajor.Text))
                    .withVMinor(Convert.ToInt32(txtVMinor.Text))
                    .withNUsers(Convert.ToInt32(txtNUsers.Text))
                    .withVoiceMail(chkVoiceMail.Checked)
                    .withFaxMail(chkFaxMail.Checked)
                    .withCampanha(chkCampanha.Checked)
                    .withXFace(chkXFace.Checked)
                    .withBroadcast(chkBroadcast.Checked)
                    .withRobot(chkRobot.Checked)
                    .withSpeech(chkSpeech.Checked)
                    .withTextToSpeech(chkTextToSpeech.Checked)
                    .build();

            status = helper.loginInHasp();

            if (HaspStatus.StatusOk != status)
            {
                return;
            }

            if (helper.writeInHasp(ref msgaux, hl))
            {
                helper.logoutInHasp();
            }

        }

        private bool validaCampos()
        {
            if (string.Empty == txtVersaoHardLock.Text)
            {
                MessageBox.Show("O campo Vers�o HardLock deve ser preenchido.", FormMain.ActiveForm.Text, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);

                txtVersaoHardLock.Focus();
                return false;
            }

            if (string.Empty == txtNCanais.Text)
            {
                MessageBox.Show("O campo Canais deve ser preenchido.", FormMain.ActiveForm.Text, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);

                txtNCanais.Focus();
                return false;
            }

            if (string.Empty == txtVMajor.Text)
            {
                MessageBox.Show("O campo Vers�o Crytal deve ser preenchido.", FormMain.ActiveForm.Text, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);

                txtVMajor.Focus();
                return false;
            }

            if (string.Empty == txtVMinor.Text)
            {
                MessageBox.Show("O campo Vers�o Crytal deve ser preenchido.", FormMain.ActiveForm.Text, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);

                txtVMinor.Focus();
                return false;
            }

            if (string.Empty == txtNUsers.Text)
            {
                MessageBox.Show("O campo M�ximo de usu�rios deve ser preenchido.", FormMain.ActiveForm.Text, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);

                txtNUsers.Focus();
                return false;
            }

            return true;
        }

        private void btnCmdLer_Click(object sender, EventArgs e)
        {
            HaspStatus status;
            string mensagem = "";

            status = helper.loginInHasp();

            if (HaspStatus.StatusOk != status)
            {
                return;
            }

            txtRead.Text = helper.readInHasp(ref status, ref mensagem);
            
            helper.logoutInHasp();
        }

        private void AceitaApenasNumeros_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (char.IsDigit(e.KeyChar)) return;
            if (char.IsControl(e.KeyChar)) return;
            
            e.Handled = true;

        }

        private void chkIlimitado_CheckedChanged(object sender, EventArgs e)
        {
            if (chkIlimitado.Checked)
            {
                if (Calendar.Enabled) Calendar.Enabled = false;
            }
            else
            {
                if (!Calendar.Enabled) Calendar.Enabled = true;
            }
        }

    }

}